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
import com.lark.oapi.core.utils.Strings;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.zip.GZIPOutputStream;

final class AppAddonsEncoder {
    private static final String ERROR_INVALID_ARGUMENT = "invalid_argument";

    private AppAddonsEncoder() {
    }

    static String encode(AppAddons addons) throws RegisterAppException {
        int itemCount = validate(addons);
        if (itemCount == 0 && !isMinimalBase(addons)) {
            throw invalid("addons must contain at least one scope, event or callback, or set preset to false");
        }

        String json = Jsons.DEFAULT.toJson(addons);
        byte[] data = gzip(json.getBytes(StandardCharsets.UTF_8));
        return Base64.getUrlEncoder().withoutPadding().encodeToString(data);
    }

    // preset=false selects the minimal base template, which is meaningful on
    // its own; only then may the incremental config lists all be empty.
    private static boolean isMinimalBase(AppAddons addons) {
        return addons != null && Boolean.FALSE.equals(addons.getPreset());
    }

    private static int validate(AppAddons addons) throws RegisterAppException {
        if (addons == null) {
            return 0;
        }

        int itemCount = 0;
        AppAddons.Scopes scopes = addons.getScopes();
        if (scopes != null) {
            itemCount += validateStringList(scopes.getTenant(), "addons.scopes.tenant");
            itemCount += validateStringList(scopes.getUser(), "addons.scopes.user");
        }

        AppAddons.Events events = addons.getEvents();
        if (events != null && events.getItems() != null) {
            itemCount += validateStringList(events.getItems().getTenant(), "addons.events.items.tenant");
            itemCount += validateStringList(events.getItems().getUser(), "addons.events.items.user");
        }

        AppAddons.Callbacks callbacks = addons.getCallbacks();
        if (callbacks != null) {
            itemCount += validateStringList(callbacks.getItems(), "addons.callbacks.items");
        }

        return itemCount;
    }

    private static int validateStringList(List<String> items, String path) throws RegisterAppException {
        if (items == null) {
            return 0;
        }
        for (int i = 0; i < items.size(); i++) {
            if (Strings.isEmpty(items.get(i))) {
                throw invalid(path + "[" + i + "] must be a non-empty string");
            }
        }
        return items.size();
    }

    private static byte[] gzip(byte[] data) throws RegisterAppException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream)) {
            gzipOutputStream.write(data);
        } catch (IOException e) {
            throw invalid("failed to encode addons");
        }
        return outputStream.toByteArray();
    }

    private static RegisterAppException invalid(String description) {
        return new RegisterAppException(ERROR_INVALID_ARGUMENT, description);
    }
}
