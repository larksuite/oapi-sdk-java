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
 * Incremental app config pre-filled into the confirm page shown after the user
 * scans the QR code.
 *
 * <p>The SDK only carries the five public config lists supported by the
 * platform page: tenant and user scopes, tenant and user events, and callbacks.
 * Sensitive manifest config such as event request URLs, security settings, and
 * encrypt keys must be updated through the application config OpenAPI instead.</p>
 */
public class AppAddons {
    private Scopes scopes;
    private Events events;
    private Callbacks callbacks;

    private AppAddons() {
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Scopes getScopes() {
        return scopes;
    }

    public Events getEvents() {
        return events;
    }

    public Callbacks getCallbacks() {
        return callbacks;
    }

    public static class Scopes {
        private List<String> tenant;
        private List<String> user;

        private Scopes() {
        }

        public List<String> getTenant() {
            return unmodifiableOrNull(tenant);
        }

        public List<String> getUser() {
            return unmodifiableOrNull(user);
        }
    }

    public static class Events {
        private EventItems items;

        private Events() {
        }

        public EventItems getItems() {
            return items;
        }
    }

    public static class EventItems {
        private List<String> tenant;
        private List<String> user;

        private EventItems() {
        }

        public List<String> getTenant() {
            return unmodifiableOrNull(tenant);
        }

        public List<String> getUser() {
            return unmodifiableOrNull(user);
        }
    }

    public static class Callbacks {
        private List<String> items;

        private Callbacks() {
        }

        public List<String> getItems() {
            return unmodifiableOrNull(items);
        }
    }

    public static class Builder {
        private final AppAddons addons = new AppAddons();

        public Builder tenantScopes(String... scopes) {
            return tenantScopes(toList(scopes));
        }

        public Builder tenantScopes(List<String> scopes) {
            ensureScopes().tenant = copyOrNull(scopes);
            return this;
        }

        public Builder userScopes(String... scopes) {
            return userScopes(toList(scopes));
        }

        public Builder userScopes(List<String> scopes) {
            ensureScopes().user = copyOrNull(scopes);
            return this;
        }

        public Builder tenantEvents(String... events) {
            return tenantEvents(toList(events));
        }

        public Builder tenantEvents(List<String> events) {
            ensureEventItems().tenant = copyOrNull(events);
            return this;
        }

        public Builder userEvents(String... events) {
            return userEvents(toList(events));
        }

        public Builder userEvents(List<String> events) {
            ensureEventItems().user = copyOrNull(events);
            return this;
        }

        public Builder callbacks(String... callbacks) {
            return callbacks(toList(callbacks));
        }

        public Builder callbacks(List<String> callbacks) {
            ensureCallbacks().items = copyOrNull(callbacks);
            return this;
        }

        public AppAddons build() {
            return addons;
        }

        private Scopes ensureScopes() {
            if (addons.scopes == null) {
                addons.scopes = new Scopes();
            }
            return addons.scopes;
        }

        private EventItems ensureEventItems() {
            if (addons.events == null) {
                addons.events = new Events();
            }
            if (addons.events.items == null) {
                addons.events.items = new EventItems();
            }
            return addons.events.items;
        }

        private Callbacks ensureCallbacks() {
            if (addons.callbacks == null) {
                addons.callbacks = new Callbacks();
            }
            return addons.callbacks;
        }
    }

    private static List<String> toList(String... values) {
        if (values == null) {
            return null;
        }
        List<String> list = new ArrayList<>(values.length);
        Collections.addAll(list, values);
        return list;
    }

    private static List<String> copyOrNull(List<String> values) {
        return values == null ? null : new ArrayList<>(values);
    }

    private static List<String> unmodifiableOrNull(List<String> values) {
        return values == null ? null : Collections.unmodifiableList(values);
    }
}
