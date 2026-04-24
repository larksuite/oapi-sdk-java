/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.lark.oapi.scene.registration;

import com.lark.oapi.core.utils.Jsons;

public class RegisterAppRealDemo {

    public static void main(String[] args) {
        String source = args.length > 0 ? args[0] : "test";
        String domain = args.length > 1 ? args[1] : "https://accounts.larksuite.com";

        try {
            RegisterAppResult result = RegisterApp.register(
                    RegisterAppOptions.newBuilder()
                            .source(source)
                            .larkDomain(domain)
                            .onQRCode(info -> {
                                System.out.println("Please scan the QR code:");
                                System.out.println(info.getUrl());
                                System.out.println(String.format("Expires in %s seconds", info.getExpireIn()));
                            })
                            .onStatusChange(info -> System.out.println(
                                    "Status: " + info.getStatus()
                                            + (info.getInterval() > 0
                                            ? String.format(" (interval: %ss)", info.getInterval())
                                            : "")
                            ))
                            .build()
            );

            System.out.println("App ID: " + result.getClientId());
            System.out.println("App Secret: " + result.getClientSecret());
            System.out.println("User Info: " + Jsons.DEFAULT.toJson(result.getUserInfo()));
        } catch (RegisterAppException e) {
            System.err.println("Failed: " + e.getCode() + " " + e.getDescription());
        }
    }
}
