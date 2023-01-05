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

package com.lark.oapi.core.token;

import com.lark.oapi.core.Config;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TestAppTicketManager {

    @Test
    public void testAppTicketPutGet() throws Exception {
        AppTicketManager appTicketManager = GlobalAppTicketManager.getAppTicketManager();
        appTicketManager.put("appId", "value1", 1, TimeUnit.SECONDS);

        Config config = new Config();
        config.setAppId("appId");
        config.setAppSecret("appSecet");
        String value = appTicketManager.get(config);

        assert value.equals("value1");
    }

    @Test
    public void testAppTicketKeyTimeout() throws Exception {
        AppTicketManager appTicketManager = GlobalAppTicketManager.getAppTicketManager();
        appTicketManager.put("appId", "value1", 1, TimeUnit.MILLISECONDS);

        Thread.sleep(2);

        Config config = new Config();
        config.setAppId("appId");
        config.setAppSecret("appSecet");
        String value = appTicketManager.get(config);

        assert value.equals("");
    }
}
