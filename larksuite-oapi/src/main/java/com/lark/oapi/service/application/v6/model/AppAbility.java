// Code generated by lark suite oapi sdk gen
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

package com.lark.oapi.service.application.v6.model;

import com.google.gson.annotations.SerializedName;

public class AppAbility {
    /**
     * 小程序能力
     * <p> 示例值：
     */
    @SerializedName("gadget")
    private Gadget gadget;
    /**
     * 网页能力
     * <p> 示例值：
     */
    @SerializedName("web_app")
    private WebApp webApp;
    /**
     * 机器人能力
     * <p> 示例值：
     */
    @SerializedName("bot")
    private Bot bot;
    /**
     * 小组件能力
     * <p> 示例值：
     */
    @SerializedName("workplace_widgets")
    private WorkplaceWidget[] workplaceWidgets;
    /**
     * 主导航小程序
     * <p> 示例值：
     */
    @SerializedName("navigate")
    private Navigate navigate;
    /**
     * 云文档应用
     * <p> 示例值：
     */
    @SerializedName("cloud_doc")
    private CloudDoc cloudDoc;
    /**
     * 云文档小组件
     * <p> 示例值：
     */
    @SerializedName("docs_blocks")
    private DocsBlock[] docsBlocks;
    /**
     * 消息快捷操作
     * <p> 示例值：
     */
    @SerializedName("message_action")
    private MessageAction messageAction;
    /**
     * 加号菜单
     * <p> 示例值：
     */
    @SerializedName("plus_menu")
    private PlusMenu plusMenu;

    // builder 开始
    public AppAbility() {
    }

    public AppAbility(Builder builder) {
        /**
         * 小程序能力
         * <p> 示例值：
         */
        this.gadget = builder.gadget;
        /**
         * 网页能力
         * <p> 示例值：
         */
        this.webApp = builder.webApp;
        /**
         * 机器人能力
         * <p> 示例值：
         */
        this.bot = builder.bot;
        /**
         * 小组件能力
         * <p> 示例值：
         */
        this.workplaceWidgets = builder.workplaceWidgets;
        /**
         * 主导航小程序
         * <p> 示例值：
         */
        this.navigate = builder.navigate;
        /**
         * 云文档应用
         * <p> 示例值：
         */
        this.cloudDoc = builder.cloudDoc;
        /**
         * 云文档小组件
         * <p> 示例值：
         */
        this.docsBlocks = builder.docsBlocks;
        /**
         * 消息快捷操作
         * <p> 示例值：
         */
        this.messageAction = builder.messageAction;
        /**
         * 加号菜单
         * <p> 示例值：
         */
        this.plusMenu = builder.plusMenu;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Gadget getGadget() {
        return this.gadget;
    }

    public void setGadget(Gadget gadget) {
        this.gadget = gadget;
    }

    public WebApp getWebApp() {
        return this.webApp;
    }

    public void setWebApp(WebApp webApp) {
        this.webApp = webApp;
    }

    public Bot getBot() {
        return this.bot;
    }

    public void setBot(Bot bot) {
        this.bot = bot;
    }

    public WorkplaceWidget[] getWorkplaceWidgets() {
        return this.workplaceWidgets;
    }

    public void setWorkplaceWidgets(WorkplaceWidget[] workplaceWidgets) {
        this.workplaceWidgets = workplaceWidgets;
    }

    public Navigate getNavigate() {
        return this.navigate;
    }

    public void setNavigate(Navigate navigate) {
        this.navigate = navigate;
    }

    public CloudDoc getCloudDoc() {
        return this.cloudDoc;
    }

    public void setCloudDoc(CloudDoc cloudDoc) {
        this.cloudDoc = cloudDoc;
    }

    public DocsBlock[] getDocsBlocks() {
        return this.docsBlocks;
    }

    public void setDocsBlocks(DocsBlock[] docsBlocks) {
        this.docsBlocks = docsBlocks;
    }

    public MessageAction getMessageAction() {
        return this.messageAction;
    }

    public void setMessageAction(MessageAction messageAction) {
        this.messageAction = messageAction;
    }

    public PlusMenu getPlusMenu() {
        return this.plusMenu;
    }

    public void setPlusMenu(PlusMenu plusMenu) {
        this.plusMenu = plusMenu;
    }

    public static class Builder {
        /**
         * 小程序能力
         * <p> 示例值：
         */
        private Gadget gadget;
        /**
         * 网页能力
         * <p> 示例值：
         */
        private WebApp webApp;
        /**
         * 机器人能力
         * <p> 示例值：
         */
        private Bot bot;
        /**
         * 小组件能力
         * <p> 示例值：
         */
        private WorkplaceWidget[] workplaceWidgets;
        /**
         * 主导航小程序
         * <p> 示例值：
         */
        private Navigate navigate;
        /**
         * 云文档应用
         * <p> 示例值：
         */
        private CloudDoc cloudDoc;
        /**
         * 云文档小组件
         * <p> 示例值：
         */
        private DocsBlock[] docsBlocks;
        /**
         * 消息快捷操作
         * <p> 示例值：
         */
        private MessageAction messageAction;
        /**
         * 加号菜单
         * <p> 示例值：
         */
        private PlusMenu plusMenu;

        /**
         * 小程序能力
         * <p> 示例值：
         *
         * @param gadget
         * @return
         */
        public Builder gadget(Gadget gadget) {
            this.gadget = gadget;
            return this;
        }


        /**
         * 网页能力
         * <p> 示例值：
         *
         * @param webApp
         * @return
         */
        public Builder webApp(WebApp webApp) {
            this.webApp = webApp;
            return this;
        }


        /**
         * 机器人能力
         * <p> 示例值：
         *
         * @param bot
         * @return
         */
        public Builder bot(Bot bot) {
            this.bot = bot;
            return this;
        }


        /**
         * 小组件能力
         * <p> 示例值：
         *
         * @param workplaceWidgets
         * @return
         */
        public Builder workplaceWidgets(WorkplaceWidget[] workplaceWidgets) {
            this.workplaceWidgets = workplaceWidgets;
            return this;
        }


        /**
         * 主导航小程序
         * <p> 示例值：
         *
         * @param navigate
         * @return
         */
        public Builder navigate(Navigate navigate) {
            this.navigate = navigate;
            return this;
        }


        /**
         * 云文档应用
         * <p> 示例值：
         *
         * @param cloudDoc
         * @return
         */
        public Builder cloudDoc(CloudDoc cloudDoc) {
            this.cloudDoc = cloudDoc;
            return this;
        }


        /**
         * 云文档小组件
         * <p> 示例值：
         *
         * @param docsBlocks
         * @return
         */
        public Builder docsBlocks(DocsBlock[] docsBlocks) {
            this.docsBlocks = docsBlocks;
            return this;
        }


        /**
         * 消息快捷操作
         * <p> 示例值：
         *
         * @param messageAction
         * @return
         */
        public Builder messageAction(MessageAction messageAction) {
            this.messageAction = messageAction;
            return this;
        }


        /**
         * 加号菜单
         * <p> 示例值：
         *
         * @param plusMenu
         * @return
         */
        public Builder plusMenu(PlusMenu plusMenu) {
            this.plusMenu = plusMenu;
            return this;
        }


        public AppAbility build() {
            return new AppAbility(this);
        }
    }
}
