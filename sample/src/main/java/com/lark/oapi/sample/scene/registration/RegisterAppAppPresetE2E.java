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

package com.lark.oapi.sample.scene.registration;

import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.scene.registration.AppPreset;
import com.lark.oapi.scene.registration.RegisterApp;
import com.lark.oapi.scene.registration.RegisterAppException;
import com.lark.oapi.scene.registration.RegisterAppOptions;
import com.lark.oapi.scene.registration.RegisterAppResult;

import java.util.ArrayList;
import java.util.List;

public class RegisterAppAppPresetE2E {
    private static final String DEFAULT_SOURCE = "manual-e2e";
    private static final String DEFAULT_DOMAIN = "https://accounts.feishu.cn";
    private static final String DEFAULT_LARK_DOMAIN = "https://accounts.larksuite.com";
    private static final String DEFAULT_AVATARS =
            "https://s1-imfile.feishucdn.com/static-resource/v1/v3_00cj_d6bebede-c56b-40a2-b767-8e9da07f3b3g,"
                    + "https://s1-imfile.feishucdn.com/static-resource/v1/v2_bc5d2075-fcbd-41f8-bfe3-5a5ecbf0f7dg";
    private static final String DEFAULT_NAME = "{user}的应用";
    private static final String DEFAULT_DESC = "由 Java SDK E2E 自动预填";

    public static void main(String[] args) {
        String source = option(args, 0, "REGISTER_APP_SOURCE", DEFAULT_SOURCE);
        String domain = option(args, 1, "REGISTER_APP_DOMAIN", DEFAULT_DOMAIN);
        String larkDomain = option(args, 2, "REGISTER_APP_LARK_DOMAIN", DEFAULT_LARK_DOMAIN);
        String avatars = option(args, 3, "REGISTER_APP_AVATARS", DEFAULT_AVATARS);
        String name = option(args, 4, "REGISTER_APP_NAME", DEFAULT_NAME);
        String desc = option(args, 5, "REGISTER_APP_DESC", DEFAULT_DESC);

        AppPreset.Builder presetBuilder = AppPreset.newBuilder()
                .name(name)
                .desc(desc);
        List<String> avatarList = splitCsv(avatars);
        if (!avatarList.isEmpty()) {
            presetBuilder.avatars(avatarList);
        }

        System.out.println("Starting real RegisterApp AppPreset E2E.");
        System.out.println("No mock server is used. The SDK will call the real registration endpoint.");
        System.out.println("source=" + source);
        System.out.println("domain=" + domain);
        System.out.println("larkDomain=" + larkDomain);
        System.out.println("avatars=" + avatarList);
        System.out.println("name=" + name);
        System.out.println("desc=" + desc);

        try {
            RegisterAppResult result = RegisterApp.register(
                    RegisterAppOptions.newBuilder()
                            .source(source)
                            .domain(domain)
                            .larkDomain(larkDomain)
                            .appPreset(presetBuilder.build())
                            .onQRCode(info -> {
                                System.out.println();
                                System.out.println("Open or scan this real verification URL:");
                                System.out.println(info.getUrl());
                                System.out.println(String.format("Expires in %s seconds", info.getExpireIn()));
                                System.out.println();
                                System.out.println("Check the app creation page for prefilled avatar/name/desc.");
                                System.out.println("The process keeps polling until you submit or the link expires.");
                            })
                            .onStatusChange(info -> System.out.println(
                                    "Status: " + info.getStatus()
                                            + (info.getInterval() > 0
                                            ? String.format(" (interval: %ss)", info.getInterval())
                                            : "")
                            ))
                            .build()
            );

            System.out.println("Registration completed.");
            System.out.println("App ID: " + result.getClientId());
            System.out.println("App Secret: " + mask(result.getClientSecret()));
            System.out.println("User Info: " + Jsons.DEFAULT.toJson(result.getUserInfo()));
        } catch (RegisterAppException e) {
            System.err.println("Registration failed: " + e.getCode() + " " + e.getDescription());
        }
    }

    private static String option(String[] args, int index, String envName, String defaultValue) {
        if (args.length > index && isNotBlank(args[index])) {
            return args[index];
        }
        String envValue = System.getenv(envName);
        if (isNotBlank(envValue)) {
            return envValue;
        }
        return defaultValue;
    }

    private static List<String> splitCsv(String value) {
        List<String> result = new ArrayList<>();
        if (!isNotBlank(value)) {
            return result;
        }
        String[] parts = value.split(",");
        for (String part : parts) {
            String trimmed = part.trim();
            if (!trimmed.isEmpty()) {
                result.add(trimmed);
            }
        }
        return result;
    }

    private static boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }

    private static String mask(String secret) {
        if (secret == null || secret.length() <= 8) {
            return "<redacted>";
        }
        return secret.substring(0, 4) + "..." + secret.substring(secret.length() - 4);
    }
}
