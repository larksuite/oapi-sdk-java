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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Pre-fill values shown on the app creation page after the user scans the QR code.
 *
 * <p>All fields are optional. Users can still edit these values on the page, and the
 * final app information is whatever the user submits from that page.</p>
 *
 * <p>The SDK appends these values to the QR code URL and performs URL encoding
 * automatically. Pass raw values such as {@code {user}的应用}; do not pre-encode them.</p>
 */
public class AppPreset {
    private List<String> avatar;
    private String name;
    private String desc;

    private AppPreset() {
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * App avatar URL candidates. Pass one to six publicly reachable image URLs.
     * The first URL is selected by default on the app creation page.
     *
     * <p>Supported image formats and rendering details are handled by the page/server:
     * png, jpg, jpeg, webp, and gif. GIF images are sampled to a single frame and are
     * not kept animated.</p>
     */
    public List<String> getAvatar() {
        if (avatar == null) {
            return null;
        }
        return Collections.unmodifiableList(avatar);
    }

    /**
     * App name. Supports the {@code {user}} placeholder, which is replaced with the
     * scanning user's name by the app creation page.
     */
    public String getName() {
        return name;
    }

    /**
     * App description. Supports the {@code {user}} placeholder, which is replaced by
     * the app creation page.
     */
    public String getDesc() {
        return desc;
    }

    public static class Builder {
        private final AppPreset preset = new AppPreset();

        public Builder avatar(String avatar) {
            preset.avatar = new ArrayList<>();
            preset.avatar.add(avatar);
            return this;
        }

        public Builder avatars(String... avatars) {
            preset.avatar = new ArrayList<>();
            if (avatars != null) {
                Collections.addAll(preset.avatar, avatars);
            }
            return this;
        }

        public Builder avatars(List<String> avatars) {
            preset.avatar = avatars == null ? null : new ArrayList<>(avatars);
            return this;
        }

        public Builder name(String name) {
            preset.name = name;
            return this;
        }

        public Builder desc(String desc) {
            preset.desc = desc;
            return this;
        }

        public AppPreset build() {
            return preset;
        }
    }
}
