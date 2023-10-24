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

package com.lark.oapi.service.lingo.v1.model;

import com.google.gson.annotations.SerializedName;

public class WordInfo {
    /**
     * 用户输入的总词汇量
     * <p> 示例值：100
     */
    @SerializedName("input_total")
    private Integer inputTotal;
    /**
     * 用户输入的去重后的总词汇量
     * <p> 示例值：50
     */
    @SerializedName("dedup_input_total")
    private Integer dedupInputTotal;
    /**
     * 时间区间内每一天发送的英文词数，时间是由远到近。以七天数据为例：下标6为昨天，下标5位前天以此类推
     * <p> 示例值：
     */
    @SerializedName("eachday_input")
    private Integer[] eachdayInput;
    /**
     * 时间区间内每一天发送的归一化去重后的英文词数，时间是由远到近。以七天数据为例：下标6为昨天，下标5位前天以此类推
     * <p> 示例值：
     */
    @SerializedName("eachday_dedup_input")
    private Integer[] eachdayDedupInput;
    /**
     * 发送的消息总数
     * <p> 示例值：200
     */
    @SerializedName("send_message_total")
    private Integer sendMessageTotal;
    /**
     * 发送的英语消息总数
     * <p> 示例值：150
     */
    @SerializedName("send_en_message_total")
    private Integer sendEnMessageTotal;
    /**
     * 接收消息的数量
     * <p> 示例值：500
     */
    @SerializedName("receive_message_total")
    private Integer receiveMessageTotal;
    /**
     * 接收英文消息的数量
     * <p> 示例值：100
     */
    @SerializedName("receive_en_message_total")
    private Integer receiveEnMessageTotal;
    /**
     * 历史总计英语词数（包含新增）
     * <p> 示例值：300
     */
    @SerializedName("history_words_total")
    private Integer historyWordsTotal;
    /**
     * 新增英语词数
     * <p> 示例值：20
     */
    @SerializedName("new_words_total")
    private Integer newWordsTotal;
    /**
     * 时间区间内每一天发送的英语消息数
     * <p> 示例值：
     */
    @SerializedName("eachday_send_en_message")
    private Integer[] eachdaySendEnMessage;
    /**
     * 时间区间内每一天发送的消息数
     * <p> 示例值：
     */
    @SerializedName("eachday_send_message")
    private Integer[] eachdaySendMessage;
    /**
     * 时间区间内每一天接收的英文消息数
     * <p> 示例值：
     */
    @SerializedName("eachday_receive_en_message")
    private Integer[] eachdayReceiveEnMessage;
    /**
     * 时间区间内每一天接收的英文消息数
     * <p> 示例值：
     */
    @SerializedName("eachday_receive_message")
    private Integer[] eachdayReceiveMessage;
    /**
     * 发送消息占比环比增长变化
     * <p> 示例值：2.1
     */
    @SerializedName("send_eng_message_rate_ring_growth")
    private Double sendEngMessageRateRingGrowth;
    /**
     * 发送英文单词数环比增长变化
     * <p> 示例值：9
     */
    @SerializedName("send_eng_words_ring_growth")
    private Integer sendEngWordsRingGrowth;

    // builder 开始
    public WordInfo() {
    }

    public WordInfo(Builder builder) {
        /**
         * 用户输入的总词汇量
         * <p> 示例值：100
         */
        this.inputTotal = builder.inputTotal;
        /**
         * 用户输入的去重后的总词汇量
         * <p> 示例值：50
         */
        this.dedupInputTotal = builder.dedupInputTotal;
        /**
         * 时间区间内每一天发送的英文词数，时间是由远到近。以七天数据为例：下标6为昨天，下标5位前天以此类推
         * <p> 示例值：
         */
        this.eachdayInput = builder.eachdayInput;
        /**
         * 时间区间内每一天发送的归一化去重后的英文词数，时间是由远到近。以七天数据为例：下标6为昨天，下标5位前天以此类推
         * <p> 示例值：
         */
        this.eachdayDedupInput = builder.eachdayDedupInput;
        /**
         * 发送的消息总数
         * <p> 示例值：200
         */
        this.sendMessageTotal = builder.sendMessageTotal;
        /**
         * 发送的英语消息总数
         * <p> 示例值：150
         */
        this.sendEnMessageTotal = builder.sendEnMessageTotal;
        /**
         * 接收消息的数量
         * <p> 示例值：500
         */
        this.receiveMessageTotal = builder.receiveMessageTotal;
        /**
         * 接收英文消息的数量
         * <p> 示例值：100
         */
        this.receiveEnMessageTotal = builder.receiveEnMessageTotal;
        /**
         * 历史总计英语词数（包含新增）
         * <p> 示例值：300
         */
        this.historyWordsTotal = builder.historyWordsTotal;
        /**
         * 新增英语词数
         * <p> 示例值：20
         */
        this.newWordsTotal = builder.newWordsTotal;
        /**
         * 时间区间内每一天发送的英语消息数
         * <p> 示例值：
         */
        this.eachdaySendEnMessage = builder.eachdaySendEnMessage;
        /**
         * 时间区间内每一天发送的消息数
         * <p> 示例值：
         */
        this.eachdaySendMessage = builder.eachdaySendMessage;
        /**
         * 时间区间内每一天接收的英文消息数
         * <p> 示例值：
         */
        this.eachdayReceiveEnMessage = builder.eachdayReceiveEnMessage;
        /**
         * 时间区间内每一天接收的英文消息数
         * <p> 示例值：
         */
        this.eachdayReceiveMessage = builder.eachdayReceiveMessage;
        /**
         * 发送消息占比环比增长变化
         * <p> 示例值：2.1
         */
        this.sendEngMessageRateRingGrowth = builder.sendEngMessageRateRingGrowth;
        /**
         * 发送英文单词数环比增长变化
         * <p> 示例值：9
         */
        this.sendEngWordsRingGrowth = builder.sendEngWordsRingGrowth;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getInputTotal() {
        return this.inputTotal;
    }

    public void setInputTotal(Integer inputTotal) {
        this.inputTotal = inputTotal;
    }

    public Integer getDedupInputTotal() {
        return this.dedupInputTotal;
    }

    public void setDedupInputTotal(Integer dedupInputTotal) {
        this.dedupInputTotal = dedupInputTotal;
    }

    public Integer[] getEachdayInput() {
        return this.eachdayInput;
    }

    public void setEachdayInput(Integer[] eachdayInput) {
        this.eachdayInput = eachdayInput;
    }

    public Integer[] getEachdayDedupInput() {
        return this.eachdayDedupInput;
    }

    public void setEachdayDedupInput(Integer[] eachdayDedupInput) {
        this.eachdayDedupInput = eachdayDedupInput;
    }

    public Integer getSendMessageTotal() {
        return this.sendMessageTotal;
    }

    public void setSendMessageTotal(Integer sendMessageTotal) {
        this.sendMessageTotal = sendMessageTotal;
    }

    public Integer getSendEnMessageTotal() {
        return this.sendEnMessageTotal;
    }

    public void setSendEnMessageTotal(Integer sendEnMessageTotal) {
        this.sendEnMessageTotal = sendEnMessageTotal;
    }

    public Integer getReceiveMessageTotal() {
        return this.receiveMessageTotal;
    }

    public void setReceiveMessageTotal(Integer receiveMessageTotal) {
        this.receiveMessageTotal = receiveMessageTotal;
    }

    public Integer getReceiveEnMessageTotal() {
        return this.receiveEnMessageTotal;
    }

    public void setReceiveEnMessageTotal(Integer receiveEnMessageTotal) {
        this.receiveEnMessageTotal = receiveEnMessageTotal;
    }

    public Integer getHistoryWordsTotal() {
        return this.historyWordsTotal;
    }

    public void setHistoryWordsTotal(Integer historyWordsTotal) {
        this.historyWordsTotal = historyWordsTotal;
    }

    public Integer getNewWordsTotal() {
        return this.newWordsTotal;
    }

    public void setNewWordsTotal(Integer newWordsTotal) {
        this.newWordsTotal = newWordsTotal;
    }

    public Integer[] getEachdaySendEnMessage() {
        return this.eachdaySendEnMessage;
    }

    public void setEachdaySendEnMessage(Integer[] eachdaySendEnMessage) {
        this.eachdaySendEnMessage = eachdaySendEnMessage;
    }

    public Integer[] getEachdaySendMessage() {
        return this.eachdaySendMessage;
    }

    public void setEachdaySendMessage(Integer[] eachdaySendMessage) {
        this.eachdaySendMessage = eachdaySendMessage;
    }

    public Integer[] getEachdayReceiveEnMessage() {
        return this.eachdayReceiveEnMessage;
    }

    public void setEachdayReceiveEnMessage(Integer[] eachdayReceiveEnMessage) {
        this.eachdayReceiveEnMessage = eachdayReceiveEnMessage;
    }

    public Integer[] getEachdayReceiveMessage() {
        return this.eachdayReceiveMessage;
    }

    public void setEachdayReceiveMessage(Integer[] eachdayReceiveMessage) {
        this.eachdayReceiveMessage = eachdayReceiveMessage;
    }

    public Double getSendEngMessageRateRingGrowth() {
        return this.sendEngMessageRateRingGrowth;
    }

    public void setSendEngMessageRateRingGrowth(Double sendEngMessageRateRingGrowth) {
        this.sendEngMessageRateRingGrowth = sendEngMessageRateRingGrowth;
    }

    public Integer getSendEngWordsRingGrowth() {
        return this.sendEngWordsRingGrowth;
    }

    public void setSendEngWordsRingGrowth(Integer sendEngWordsRingGrowth) {
        this.sendEngWordsRingGrowth = sendEngWordsRingGrowth;
    }

    public static class Builder {
        /**
         * 用户输入的总词汇量
         * <p> 示例值：100
         */
        private Integer inputTotal;
        /**
         * 用户输入的去重后的总词汇量
         * <p> 示例值：50
         */
        private Integer dedupInputTotal;
        /**
         * 时间区间内每一天发送的英文词数，时间是由远到近。以七天数据为例：下标6为昨天，下标5位前天以此类推
         * <p> 示例值：
         */
        private Integer[] eachdayInput;
        /**
         * 时间区间内每一天发送的归一化去重后的英文词数，时间是由远到近。以七天数据为例：下标6为昨天，下标5位前天以此类推
         * <p> 示例值：
         */
        private Integer[] eachdayDedupInput;
        /**
         * 发送的消息总数
         * <p> 示例值：200
         */
        private Integer sendMessageTotal;
        /**
         * 发送的英语消息总数
         * <p> 示例值：150
         */
        private Integer sendEnMessageTotal;
        /**
         * 接收消息的数量
         * <p> 示例值：500
         */
        private Integer receiveMessageTotal;
        /**
         * 接收英文消息的数量
         * <p> 示例值：100
         */
        private Integer receiveEnMessageTotal;
        /**
         * 历史总计英语词数（包含新增）
         * <p> 示例值：300
         */
        private Integer historyWordsTotal;
        /**
         * 新增英语词数
         * <p> 示例值：20
         */
        private Integer newWordsTotal;
        /**
         * 时间区间内每一天发送的英语消息数
         * <p> 示例值：
         */
        private Integer[] eachdaySendEnMessage;
        /**
         * 时间区间内每一天发送的消息数
         * <p> 示例值：
         */
        private Integer[] eachdaySendMessage;
        /**
         * 时间区间内每一天接收的英文消息数
         * <p> 示例值：
         */
        private Integer[] eachdayReceiveEnMessage;
        /**
         * 时间区间内每一天接收的英文消息数
         * <p> 示例值：
         */
        private Integer[] eachdayReceiveMessage;
        /**
         * 发送消息占比环比增长变化
         * <p> 示例值：2.1
         */
        private Double sendEngMessageRateRingGrowth;
        /**
         * 发送英文单词数环比增长变化
         * <p> 示例值：9
         */
        private Integer sendEngWordsRingGrowth;

        /**
         * 用户输入的总词汇量
         * <p> 示例值：100
         *
         * @param inputTotal
         * @return
         */
        public Builder inputTotal(Integer inputTotal) {
            this.inputTotal = inputTotal;
            return this;
        }


        /**
         * 用户输入的去重后的总词汇量
         * <p> 示例值：50
         *
         * @param dedupInputTotal
         * @return
         */
        public Builder dedupInputTotal(Integer dedupInputTotal) {
            this.dedupInputTotal = dedupInputTotal;
            return this;
        }


        /**
         * 时间区间内每一天发送的英文词数，时间是由远到近。以七天数据为例：下标6为昨天，下标5位前天以此类推
         * <p> 示例值：
         *
         * @param eachdayInput
         * @return
         */
        public Builder eachdayInput(Integer[] eachdayInput) {
            this.eachdayInput = eachdayInput;
            return this;
        }


        /**
         * 时间区间内每一天发送的归一化去重后的英文词数，时间是由远到近。以七天数据为例：下标6为昨天，下标5位前天以此类推
         * <p> 示例值：
         *
         * @param eachdayDedupInput
         * @return
         */
        public Builder eachdayDedupInput(Integer[] eachdayDedupInput) {
            this.eachdayDedupInput = eachdayDedupInput;
            return this;
        }


        /**
         * 发送的消息总数
         * <p> 示例值：200
         *
         * @param sendMessageTotal
         * @return
         */
        public Builder sendMessageTotal(Integer sendMessageTotal) {
            this.sendMessageTotal = sendMessageTotal;
            return this;
        }


        /**
         * 发送的英语消息总数
         * <p> 示例值：150
         *
         * @param sendEnMessageTotal
         * @return
         */
        public Builder sendEnMessageTotal(Integer sendEnMessageTotal) {
            this.sendEnMessageTotal = sendEnMessageTotal;
            return this;
        }


        /**
         * 接收消息的数量
         * <p> 示例值：500
         *
         * @param receiveMessageTotal
         * @return
         */
        public Builder receiveMessageTotal(Integer receiveMessageTotal) {
            this.receiveMessageTotal = receiveMessageTotal;
            return this;
        }


        /**
         * 接收英文消息的数量
         * <p> 示例值：100
         *
         * @param receiveEnMessageTotal
         * @return
         */
        public Builder receiveEnMessageTotal(Integer receiveEnMessageTotal) {
            this.receiveEnMessageTotal = receiveEnMessageTotal;
            return this;
        }


        /**
         * 历史总计英语词数（包含新增）
         * <p> 示例值：300
         *
         * @param historyWordsTotal
         * @return
         */
        public Builder historyWordsTotal(Integer historyWordsTotal) {
            this.historyWordsTotal = historyWordsTotal;
            return this;
        }


        /**
         * 新增英语词数
         * <p> 示例值：20
         *
         * @param newWordsTotal
         * @return
         */
        public Builder newWordsTotal(Integer newWordsTotal) {
            this.newWordsTotal = newWordsTotal;
            return this;
        }


        /**
         * 时间区间内每一天发送的英语消息数
         * <p> 示例值：
         *
         * @param eachdaySendEnMessage
         * @return
         */
        public Builder eachdaySendEnMessage(Integer[] eachdaySendEnMessage) {
            this.eachdaySendEnMessage = eachdaySendEnMessage;
            return this;
        }


        /**
         * 时间区间内每一天发送的消息数
         * <p> 示例值：
         *
         * @param eachdaySendMessage
         * @return
         */
        public Builder eachdaySendMessage(Integer[] eachdaySendMessage) {
            this.eachdaySendMessage = eachdaySendMessage;
            return this;
        }


        /**
         * 时间区间内每一天接收的英文消息数
         * <p> 示例值：
         *
         * @param eachdayReceiveEnMessage
         * @return
         */
        public Builder eachdayReceiveEnMessage(Integer[] eachdayReceiveEnMessage) {
            this.eachdayReceiveEnMessage = eachdayReceiveEnMessage;
            return this;
        }


        /**
         * 时间区间内每一天接收的英文消息数
         * <p> 示例值：
         *
         * @param eachdayReceiveMessage
         * @return
         */
        public Builder eachdayReceiveMessage(Integer[] eachdayReceiveMessage) {
            this.eachdayReceiveMessage = eachdayReceiveMessage;
            return this;
        }


        /**
         * 发送消息占比环比增长变化
         * <p> 示例值：2.1
         *
         * @param sendEngMessageRateRingGrowth
         * @return
         */
        public Builder sendEngMessageRateRingGrowth(Double sendEngMessageRateRingGrowth) {
            this.sendEngMessageRateRingGrowth = sendEngMessageRateRingGrowth;
            return this;
        }


        /**
         * 发送英文单词数环比增长变化
         * <p> 示例值：9
         *
         * @param sendEngWordsRingGrowth
         * @return
         */
        public Builder sendEngWordsRingGrowth(Integer sendEngWordsRingGrowth) {
            this.sendEngWordsRingGrowth = sendEngWordsRingGrowth;
            return this;
        }


        public WordInfo build() {
            return new WordInfo(this);
        }
    }
}
