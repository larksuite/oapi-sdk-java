/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice, shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.lark.oapi.core.utils;

import com.lark.oapi.core.exception.DecryptException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Decryptor {

    private byte[] key;

    public Decryptor(String keyStr) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            // won't happen
        }
        key = digest.digest(keyStr.getBytes(StandardCharsets.UTF_8));
    }

    public String decrypt(String base64) throws DecryptException {
        try {
            byte[] decode = Base64.getDecoder().decode(base64);
            Cipher cipher = Cipher.getInstance("AES/CBC/NOPADDING");
            byte[] iv = new byte[16];
            System.arraycopy(decode, 0, iv, 0, 16);
            byte[] data = new byte[decode.length - 16];
            System.arraycopy(decode, 16, data, 0, data.length);
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
            byte[] r = cipher.doFinal(data);
            if (r.length > 0) {
                int p = r.length - 1;
                for (; p >= 0 && r[p] <= 16; p--) {
                }
                if (p != r.length - 1) {
                    byte[] rr = new byte[p + 1];
                    System.arraycopy(r, 0, rr, 0, p + 1);
                    r = rr;
                }
            }
            return new String(r, StandardCharsets.UTF_8);
        } catch (Throwable e) {
            throw new DecryptException(e);
        }
    }
}
