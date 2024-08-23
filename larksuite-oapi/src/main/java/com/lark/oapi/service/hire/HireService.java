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
package com.lark.oapi.service.hire;

import com.lark.oapi.core.Config;
import com.lark.oapi.event.IEventHandler;
import com.lark.oapi.service.hire.v1.V1;
import com.lark.oapi.service.hire.v1.model.*;
import com.lark.oapi.service.hire.v1.resource.Advertisement;
import com.lark.oapi.service.hire.v1.resource.Agency;
import com.lark.oapi.service.hire.v1.resource.Application;
import com.lark.oapi.service.hire.v1.resource.ApplicationInterview;
import com.lark.oapi.service.hire.v1.resource.Attachment;
import com.lark.oapi.service.hire.v1.resource.BackgroundCheckOrder;
import com.lark.oapi.service.hire.v1.resource.DiversityInclusion;
import com.lark.oapi.service.hire.v1.resource.EcoAccount;
import com.lark.oapi.service.hire.v1.resource.EcoAccountCustomField;
import com.lark.oapi.service.hire.v1.resource.EcoBackgroundCheck;
import com.lark.oapi.service.hire.v1.resource.EcoBackgroundCheckCustomField;
import com.lark.oapi.service.hire.v1.resource.EcoBackgroundCheckPackage;
import com.lark.oapi.service.hire.v1.resource.EcoExam;
import com.lark.oapi.service.hire.v1.resource.EcoExamPaper;
import com.lark.oapi.service.hire.v1.resource.EhrImportTask;
import com.lark.oapi.service.hire.v1.resource.EhrImportTaskForInternshipOffer;
import com.lark.oapi.service.hire.v1.resource.Employee;
import com.lark.oapi.service.hire.v1.resource.Evaluation;
import com.lark.oapi.service.hire.v1.resource.EvaluationTask;
import com.lark.oapi.service.hire.v1.resource.Exam;
import com.lark.oapi.service.hire.v1.resource.ExamMarkingTask;
import com.lark.oapi.service.hire.v1.resource.ExternalApplication;
import com.lark.oapi.service.hire.v1.resource.ExternalBackgroundCheck;
import com.lark.oapi.service.hire.v1.resource.ExternalInterview;
import com.lark.oapi.service.hire.v1.resource.ExternalInterviewAssessment;
import com.lark.oapi.service.hire.v1.resource.ExternalReferralReward;
import com.lark.oapi.service.hire.v1.resource.Interview;
import com.lark.oapi.service.hire.v1.resource.InterviewFeedbackForm;
import com.lark.oapi.service.hire.v1.resource.InterviewRecord;
import com.lark.oapi.service.hire.v1.resource.InterviewRecordAttachment;
import com.lark.oapi.service.hire.v1.resource.InterviewRegistrationSchema;
import com.lark.oapi.service.hire.v1.resource.InterviewRoundType;
import com.lark.oapi.service.hire.v1.resource.InterviewTask;
import com.lark.oapi.service.hire.v1.resource.Job;
import com.lark.oapi.service.hire.v1.resource.JobManager;
import com.lark.oapi.service.hire.v1.resource.JobFunction;
import com.lark.oapi.service.hire.v1.resource.JobProcess;
import com.lark.oapi.service.hire.v1.resource.JobPublishRecord;
import com.lark.oapi.service.hire.v1.resource.JobRequirement;
import com.lark.oapi.service.hire.v1.resource.JobRequirementSchema;
import com.lark.oapi.service.hire.v1.resource.JobSchema;
import com.lark.oapi.service.hire.v1.resource.JobType;
import com.lark.oapi.service.hire.v1.resource.Location;
import com.lark.oapi.service.hire.v1.resource.Note;
import com.lark.oapi.service.hire.v1.resource.Offer;
import com.lark.oapi.service.hire.v1.resource.OfferApplicationForm;
import com.lark.oapi.service.hire.v1.resource.OfferCustomField;
import com.lark.oapi.service.hire.v1.resource.OfferSchema;
import com.lark.oapi.service.hire.v1.resource.Questionnaire;
import com.lark.oapi.service.hire.v1.resource.Referral;
import com.lark.oapi.service.hire.v1.resource.ReferralAccount;
import com.lark.oapi.service.hire.v1.resource.ReferralWebsiteJobPost;
import com.lark.oapi.service.hire.v1.resource.RegistrationSchema;
import com.lark.oapi.service.hire.v1.resource.ResumeSource;
import com.lark.oapi.service.hire.v1.resource.Role;
import com.lark.oapi.service.hire.v1.resource.Subject;
import com.lark.oapi.service.hire.v1.resource.Talent;
import com.lark.oapi.service.hire.v1.resource.TalentExternalInfo;
import com.lark.oapi.service.hire.v1.resource.TalentFolder;
import com.lark.oapi.service.hire.v1.resource.TalentObject;
import com.lark.oapi.service.hire.v1.resource.TalentOperationLog;
import com.lark.oapi.service.hire.v1.resource.TalentPool;
import com.lark.oapi.service.hire.v1.resource.TerminationReason;
import com.lark.oapi.service.hire.v1.resource.Test;
import com.lark.oapi.service.hire.v1.resource.Todo;
import com.lark.oapi.service.hire.v1.resource.TripartiteAgreement;
import com.lark.oapi.service.hire.v1.resource.Website;
import com.lark.oapi.service.hire.v1.resource.WebsiteChannel;
import com.lark.oapi.service.hire.v1.resource.WebsiteDelivery;
import com.lark.oapi.service.hire.v1.resource.WebsiteDeliveryTask;
import com.lark.oapi.service.hire.v1.resource.WebsiteJobPost;
import com.lark.oapi.service.hire.v1.resource.WebsiteSiteUser;

public class HireService {
    private final V1 v1;
    private final Advertisement advertisement; // advertisement
    private final Agency agency; // 猎头（灰度租户可见）
    private final Application application; // 入职
    private final ApplicationInterview applicationInterview; // application.interview
    private final Attachment attachment; // 附件
    private final BackgroundCheckOrder backgroundCheckOrder; // 背调 （灰度租户可见）
    private final DiversityInclusion diversityInclusion; // diversity_inclusion
    private final EcoAccount ecoAccount; // 事件
    private final EcoAccountCustomField ecoAccountCustomField; // 生态对接账号自定义字段
    private final EcoBackgroundCheck ecoBackgroundCheck; // 背调订单
    private final EcoBackgroundCheckCustomField ecoBackgroundCheckCustomField; // 背调自定义字段
    private final EcoBackgroundCheckPackage ecoBackgroundCheckPackage; // 背调套餐和附加调查项
    private final EcoExam ecoExam; // eco_exam
    private final EcoExamPaper ecoExamPaper; // eco_exam_paper
    private final EhrImportTask ehrImportTask; // 导入 e-HR
    private final EhrImportTaskForInternshipOffer ehrImportTaskForInternshipOffer; // ehr_import_task_for_internship_offer
    private final Employee employee; // 入职
    private final Evaluation evaluation; // 评估（灰度租户可见）
    private final EvaluationTask evaluationTask; // 评估任务
    private final Exam exam; // 笔试 (灰度租户可见)
    private final ExamMarkingTask examMarkingTask; // 笔试阅卷任务
    private final ExternalApplication externalApplication; // 导入外部系统信息（灰度租户可见）
    private final ExternalBackgroundCheck externalBackgroundCheck; // 导入外部系统信息（灰度租户可见）
    private final ExternalInterview externalInterview; // 导入外部系统信息（灰度租户可见）
    private final ExternalInterviewAssessment externalInterviewAssessment; // 导入外部系统信息（灰度租户可见）
    private final ExternalReferralReward externalReferralReward; // external_referral_reward
    private final Interview interview; // 面试
    private final InterviewFeedbackForm interviewFeedbackForm; // interview_feedback_form
    private final InterviewRecord interviewRecord; // interview_record
    private final InterviewRecordAttachment interviewRecordAttachment; // interview_record.attachment
    private final InterviewRegistrationSchema interviewRegistrationSchema; // interview_registration_schema
    private final InterviewRoundType interviewRoundType; // 面试轮次类型
    private final InterviewTask interviewTask; // 面试任务
    private final Job job; // 职位
    private final JobManager jobManager; // job.manager
    private final JobFunction jobFunction; // job_function
    private final JobProcess jobProcess; // 流程
    private final JobPublishRecord jobPublishRecord; // job_publish_record
    private final JobRequirement jobRequirement; // 招聘需求（灰度租户可见）
    private final JobRequirementSchema jobRequirementSchema; // job_requirement_schema
    private final JobSchema jobSchema; // job_schema
    private final JobType jobType; // job_type
    private final Location location; // 地址（灰度租户可见）
    private final Note note; // 备注
    private final Offer offer; // Offer
    private final OfferApplicationForm offerApplicationForm; // Offer 申请表（灰度租户可见）
    private final OfferCustomField offerCustomField; // offer_custom_field
    private final OfferSchema offerSchema; // offer_schema
    private final Questionnaire questionnaire; // 问卷（灰度租户可见）
    private final Referral referral; // 内推
    private final ReferralAccount referralAccount; // referral_account
    private final ReferralWebsiteJobPost referralWebsiteJobPost; // referral_website.job_post
    private final RegistrationSchema registrationSchema; // registration_schema
    private final ResumeSource resumeSource; // 简历来源
    private final Role role; // 权限
    private final Subject subject; // 项目（灰度租户可见）
    private final Talent talent; // 人才
    private final TalentExternalInfo talentExternalInfo; // 导入外部系统信息（灰度租户可见）
    private final TalentFolder talentFolder; // talent_folder
    private final TalentObject talentObject; // talent_object
    private final TalentOperationLog talentOperationLog; // talent_operation_log
    private final TalentPool talentPool; // talent_pool
    private final TerminationReason terminationReason; // termination_reason
    private final Test test; // test
    private final Todo todo; // 待办
    private final TripartiteAgreement tripartiteAgreement; // tripartite_agreement
    private final Website website; // 官网（灰度租户可见）
    private final WebsiteChannel websiteChannel; // website.channel
    private final WebsiteDelivery websiteDelivery; // website.delivery
    private final WebsiteDeliveryTask websiteDeliveryTask; // website.delivery_task
    private final WebsiteJobPost websiteJobPost; // website.job_post
    private final WebsiteSiteUser websiteSiteUser; // website.site_user

    public HireService(Config config) {
        this.v1 = new V1(config);
        this.advertisement = new Advertisement(config);
        this.agency = new Agency(config);
        this.application = new Application(config);
        this.applicationInterview = new ApplicationInterview(config);
        this.attachment = new Attachment(config);
        this.backgroundCheckOrder = new BackgroundCheckOrder(config);
        this.diversityInclusion = new DiversityInclusion(config);
        this.ecoAccount = new EcoAccount(config);
        this.ecoAccountCustomField = new EcoAccountCustomField(config);
        this.ecoBackgroundCheck = new EcoBackgroundCheck(config);
        this.ecoBackgroundCheckCustomField = new EcoBackgroundCheckCustomField(config);
        this.ecoBackgroundCheckPackage = new EcoBackgroundCheckPackage(config);
        this.ecoExam = new EcoExam(config);
        this.ecoExamPaper = new EcoExamPaper(config);
        this.ehrImportTask = new EhrImportTask(config);
        this.ehrImportTaskForInternshipOffer = new EhrImportTaskForInternshipOffer(config);
        this.employee = new Employee(config);
        this.evaluation = new Evaluation(config);
        this.evaluationTask = new EvaluationTask(config);
        this.exam = new Exam(config);
        this.examMarkingTask = new ExamMarkingTask(config);
        this.externalApplication = new ExternalApplication(config);
        this.externalBackgroundCheck = new ExternalBackgroundCheck(config);
        this.externalInterview = new ExternalInterview(config);
        this.externalInterviewAssessment = new ExternalInterviewAssessment(config);
        this.externalReferralReward = new ExternalReferralReward(config);
        this.interview = new Interview(config);
        this.interviewFeedbackForm = new InterviewFeedbackForm(config);
        this.interviewRecord = new InterviewRecord(config);
        this.interviewRecordAttachment = new InterviewRecordAttachment(config);
        this.interviewRegistrationSchema = new InterviewRegistrationSchema(config);
        this.interviewRoundType = new InterviewRoundType(config);
        this.interviewTask = new InterviewTask(config);
        this.job = new Job(config);
        this.jobManager = new JobManager(config);
        this.jobFunction = new JobFunction(config);
        this.jobProcess = new JobProcess(config);
        this.jobPublishRecord = new JobPublishRecord(config);
        this.jobRequirement = new JobRequirement(config);
        this.jobRequirementSchema = new JobRequirementSchema(config);
        this.jobSchema = new JobSchema(config);
        this.jobType = new JobType(config);
        this.location = new Location(config);
        this.note = new Note(config);
        this.offer = new Offer(config);
        this.offerApplicationForm = new OfferApplicationForm(config);
        this.offerCustomField = new OfferCustomField(config);
        this.offerSchema = new OfferSchema(config);
        this.questionnaire = new Questionnaire(config);
        this.referral = new Referral(config);
        this.referralAccount = new ReferralAccount(config);
        this.referralWebsiteJobPost = new ReferralWebsiteJobPost(config);
        this.registrationSchema = new RegistrationSchema(config);
        this.resumeSource = new ResumeSource(config);
        this.role = new Role(config);
        this.subject = new Subject(config);
        this.talent = new Talent(config);
        this.talentExternalInfo = new TalentExternalInfo(config);
        this.talentFolder = new TalentFolder(config);
        this.talentObject = new TalentObject(config);
        this.talentOperationLog = new TalentOperationLog(config);
        this.talentPool = new TalentPool(config);
        this.terminationReason = new TerminationReason(config);
        this.test = new Test(config);
        this.todo = new Todo(config);
        this.tripartiteAgreement = new TripartiteAgreement(config);
        this.website = new Website(config);
        this.websiteChannel = new WebsiteChannel(config);
        this.websiteDelivery = new WebsiteDelivery(config);
        this.websiteDeliveryTask = new WebsiteDeliveryTask(config);
        this.websiteJobPost = new WebsiteJobPost(config);
        this.websiteSiteUser = new WebsiteSiteUser(config);
    }

    public V1 v1() {
        return v1;
    }

    public Advertisement advertisement() {
        return advertisement;
    }

    public Agency agency() {
        return agency;
    }

    public Application application() {
        return application;
    }

    public ApplicationInterview applicationInterview() {
        return applicationInterview;
    }

    public Attachment attachment() {
        return attachment;
    }

    public BackgroundCheckOrder backgroundCheckOrder() {
        return backgroundCheckOrder;
    }

    public DiversityInclusion diversityInclusion() {
        return diversityInclusion;
    }

    public EcoAccount ecoAccount() {
        return ecoAccount;
    }

    public EcoAccountCustomField ecoAccountCustomField() {
        return ecoAccountCustomField;
    }

    public EcoBackgroundCheck ecoBackgroundCheck() {
        return ecoBackgroundCheck;
    }

    public EcoBackgroundCheckCustomField ecoBackgroundCheckCustomField() {
        return ecoBackgroundCheckCustomField;
    }

    public EcoBackgroundCheckPackage ecoBackgroundCheckPackage() {
        return ecoBackgroundCheckPackage;
    }

    public EcoExam ecoExam() {
        return ecoExam;
    }

    public EcoExamPaper ecoExamPaper() {
        return ecoExamPaper;
    }

    public EhrImportTask ehrImportTask() {
        return ehrImportTask;
    }

    public EhrImportTaskForInternshipOffer ehrImportTaskForInternshipOffer() {
        return ehrImportTaskForInternshipOffer;
    }

    public Employee employee() {
        return employee;
    }

    public Evaluation evaluation() {
        return evaluation;
    }

    public EvaluationTask evaluationTask() {
        return evaluationTask;
    }

    public Exam exam() {
        return exam;
    }

    public ExamMarkingTask examMarkingTask() {
        return examMarkingTask;
    }

    public ExternalApplication externalApplication() {
        return externalApplication;
    }

    public ExternalBackgroundCheck externalBackgroundCheck() {
        return externalBackgroundCheck;
    }

    public ExternalInterview externalInterview() {
        return externalInterview;
    }

    public ExternalInterviewAssessment externalInterviewAssessment() {
        return externalInterviewAssessment;
    }

    public ExternalReferralReward externalReferralReward() {
        return externalReferralReward;
    }

    public Interview interview() {
        return interview;
    }

    public InterviewFeedbackForm interviewFeedbackForm() {
        return interviewFeedbackForm;
    }

    public InterviewRecord interviewRecord() {
        return interviewRecord;
    }

    public InterviewRecordAttachment interviewRecordAttachment() {
        return interviewRecordAttachment;
    }

    public InterviewRegistrationSchema interviewRegistrationSchema() {
        return interviewRegistrationSchema;
    }

    public InterviewRoundType interviewRoundType() {
        return interviewRoundType;
    }

    public InterviewTask interviewTask() {
        return interviewTask;
    }

    public Job job() {
        return job;
    }

    public JobManager jobManager() {
        return jobManager;
    }

    public JobFunction jobFunction() {
        return jobFunction;
    }

    public JobProcess jobProcess() {
        return jobProcess;
    }

    public JobPublishRecord jobPublishRecord() {
        return jobPublishRecord;
    }

    public JobRequirement jobRequirement() {
        return jobRequirement;
    }

    public JobRequirementSchema jobRequirementSchema() {
        return jobRequirementSchema;
    }

    public JobSchema jobSchema() {
        return jobSchema;
    }

    public JobType jobType() {
        return jobType;
    }

    public Location location() {
        return location;
    }

    public Note note() {
        return note;
    }

    public Offer offer() {
        return offer;
    }

    public OfferApplicationForm offerApplicationForm() {
        return offerApplicationForm;
    }

    public OfferCustomField offerCustomField() {
        return offerCustomField;
    }

    public OfferSchema offerSchema() {
        return offerSchema;
    }

    public Questionnaire questionnaire() {
        return questionnaire;
    }

    public Referral referral() {
        return referral;
    }

    public ReferralAccount referralAccount() {
        return referralAccount;
    }

    public ReferralWebsiteJobPost referralWebsiteJobPost() {
        return referralWebsiteJobPost;
    }

    public RegistrationSchema registrationSchema() {
        return registrationSchema;
    }

    public ResumeSource resumeSource() {
        return resumeSource;
    }

    public Role role() {
        return role;
    }

    public Subject subject() {
        return subject;
    }

    public Talent talent() {
        return talent;
    }

    public TalentExternalInfo talentExternalInfo() {
        return talentExternalInfo;
    }

    public TalentFolder talentFolder() {
        return talentFolder;
    }

    public TalentObject talentObject() {
        return talentObject;
    }

    public TalentOperationLog talentOperationLog() {
        return talentOperationLog;
    }

    public TalentPool talentPool() {
        return talentPool;
    }

    public TerminationReason terminationReason() {
        return terminationReason;
    }

    public Test test() {
        return test;
    }

    public Todo todo() {
        return todo;
    }

    public TripartiteAgreement tripartiteAgreement() {
        return tripartiteAgreement;
    }

    public Website website() {
        return website;
    }

    public WebsiteChannel websiteChannel() {
        return websiteChannel;
    }

    public WebsiteDelivery websiteDelivery() {
        return websiteDelivery;
    }

    public WebsiteDeliveryTask websiteDeliveryTask() {
        return websiteDeliveryTask;
    }

    public WebsiteJobPost websiteJobPost() {
        return websiteJobPost;
    }

    public WebsiteSiteUser websiteSiteUser() {
        return websiteSiteUser;
    }

    public abstract static class P2ApplicationDeletedV1Handler implements IEventHandler<P2ApplicationDeletedV1> {
        @Override
        public P2ApplicationDeletedV1 getEvent() {
            return new P2ApplicationDeletedV1();
        }
    }

    public abstract static class P2ApplicationStageChangedV1Handler implements IEventHandler<P2ApplicationStageChangedV1> {
        @Override
        public P2ApplicationStageChangedV1 getEvent() {
            return new P2ApplicationStageChangedV1();
        }
    }

    public abstract static class P2EcoAccountCreatedV1Handler implements IEventHandler<P2EcoAccountCreatedV1> {
        @Override
        public P2EcoAccountCreatedV1 getEvent() {
            return new P2EcoAccountCreatedV1();
        }
    }

    public abstract static class P2EcoBackgroundCheckCanceledV1Handler implements IEventHandler<P2EcoBackgroundCheckCanceledV1> {
        @Override
        public P2EcoBackgroundCheckCanceledV1 getEvent() {
            return new P2EcoBackgroundCheckCanceledV1();
        }
    }

    public abstract static class P2EcoBackgroundCheckCreatedV1Handler implements IEventHandler<P2EcoBackgroundCheckCreatedV1> {
        @Override
        public P2EcoBackgroundCheckCreatedV1 getEvent() {
            return new P2EcoBackgroundCheckCreatedV1();
        }
    }

    public abstract static class P2EcoExamCreatedV1Handler implements IEventHandler<P2EcoExamCreatedV1> {
        @Override
        public P2EcoExamCreatedV1 getEvent() {
            return new P2EcoExamCreatedV1();
        }
    }

    public abstract static class P2EhrImportTaskImportedV1Handler implements IEventHandler<P2EhrImportTaskImportedV1> {
        @Override
        public P2EhrImportTaskImportedV1 getEvent() {
            return new P2EhrImportTaskImportedV1();
        }
    }

    public abstract static class P2EhrImportTaskForInternshipOfferImportedV1Handler implements IEventHandler<P2EhrImportTaskForInternshipOfferImportedV1> {
        @Override
        public P2EhrImportTaskForInternshipOfferImportedV1 getEvent() {
            return new P2EhrImportTaskForInternshipOfferImportedV1();
        }
    }

    public abstract static class P2OfferStatusChangedV1Handler implements IEventHandler<P2OfferStatusChangedV1> {
        @Override
        public P2OfferStatusChangedV1 getEvent() {
            return new P2OfferStatusChangedV1();
        }
    }

    public abstract static class P2ReferralAccountAssetsUpdateV1Handler implements IEventHandler<P2ReferralAccountAssetsUpdateV1> {
        @Override
        public P2ReferralAccountAssetsUpdateV1 getEvent() {
            return new P2ReferralAccountAssetsUpdateV1();
        }
    }

    public abstract static class P2TalentDeletedV1Handler implements IEventHandler<P2TalentDeletedV1> {
        @Override
        public P2TalentDeletedV1 getEvent() {
            return new P2TalentDeletedV1();
        }
    }
}