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
package com.lark.oapi.service.approval;

import com.lark.oapi.core.Config;
import com.lark.oapi.event.IEventHandler;
import com.lark.oapi.service.approval.v4.V4;
import com.lark.oapi.service.approval.v4.model.*;
import com.lark.oapi.service.approval.v4.resource.Approval;
import com.lark.oapi.service.approval.v4.resource.ExternalApproval;
import com.lark.oapi.service.approval.v4.resource.ExternalInstance;
import com.lark.oapi.service.approval.v4.resource.ExternalTask;
import com.lark.oapi.service.approval.v4.resource.Instance;
import com.lark.oapi.service.approval.v4.resource.InstanceComment;
import com.lark.oapi.service.approval.v4.resource.Task;

public class ApprovalService {
    private final V4 v4;
    private final Approval approval; // 事件
    private final ExternalApproval externalApproval; // 三方审批定义
    private final ExternalInstance externalInstance; // 三方审批实例
    private final ExternalTask externalTask; // 三方审批任务
    private final Instance instance; // 审批查询
    private final InstanceComment instanceComment; // 原生审批评论
    private final Task task; // 原生审批任务

    public ApprovalService(Config config) {
        this.v4 = new V4(config);
        this.approval = new Approval(config);
        this.externalApproval = new ExternalApproval(config);
        this.externalInstance = new ExternalInstance(config);
        this.externalTask = new ExternalTask(config);
        this.instance = new Instance(config);
        this.instanceComment = new InstanceComment(config);
        this.task = new Task(config);
    }

    public V4 v4() {
        return v4;
    }

    public Approval approval() {
        return approval;
    }

    public ExternalApproval externalApproval() {
        return externalApproval;
    }

    public ExternalInstance externalInstance() {
        return externalInstance;
    }

    public ExternalTask externalTask() {
        return externalTask;
    }

    public Instance instance() {
        return instance;
    }

    public InstanceComment instanceComment() {
        return instanceComment;
    }

    public Task task() {
        return task;
    }

    public abstract static class P2ApprovalUpdatedV4Handler implements IEventHandler<P2ApprovalUpdatedV4> {
        @Override
        public P2ApprovalUpdatedV4 getEvent() {
            return new P2ApprovalUpdatedV4();
        }
    }

    public abstract static class P1LeaveApprovalV4Handler implements IEventHandler<P1LeaveApprovalV4> {
        @Override
        public P1LeaveApprovalV4 getEvent() {
            return new P1LeaveApprovalV4();
        }
    }

    public abstract static class P1WorkApprovalV4Handler implements IEventHandler<P1WorkApprovalV4> {
        @Override
        public P1WorkApprovalV4 getEvent() {
            return new P1WorkApprovalV4();
        }
    }

    public abstract static class P1ShiftApprovalV4Handler implements IEventHandler<P1ShiftApprovalV4> {
        @Override
        public P1ShiftApprovalV4 getEvent() {
            return new P1ShiftApprovalV4();
        }
    }

    public abstract static class P1RemedyApprovalV4Handler implements IEventHandler<P1RemedyApprovalV4> {
        @Override
        public P1RemedyApprovalV4 getEvent() {
            return new P1RemedyApprovalV4();
        }
    }

    public abstract static class P1TripApprovalV4Handler implements IEventHandler<P1TripApprovalV4> {
        @Override
        public P1TripApprovalV4 getEvent() {
            return new P1TripApprovalV4();
        }
    }


    public abstract static class P1OutApprovalV4Handler implements IEventHandler<P1OutApprovalV4> {
        @Override
        public P1OutApprovalV4 getEvent() {
            return new P1OutApprovalV4();
        }
    }
}