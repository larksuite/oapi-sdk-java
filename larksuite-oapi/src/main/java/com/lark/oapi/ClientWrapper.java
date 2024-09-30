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

package com.lark.oapi;

import com.lark.oapi.core.Config;
import com.lark.oapi.core.request.RequestOptions;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.token.AccessTokenType;
import com.lark.oapi.service.acs.v1.AcsService;
import com.lark.oapi.service.admin.v1.AdminService;
import com.lark.oapi.service.application.v6.ApplicationService;
import com.lark.oapi.service.approval.v4.ApprovalService;
import com.lark.oapi.service.attendance.v1.AttendanceService;
import com.lark.oapi.service.auth.v3.AuthService;
import com.lark.oapi.service.authen.v1.AuthenService;
import com.lark.oapi.service.baike.v1.BaikeService;
import com.lark.oapi.service.bitable.v1.BitableService;
import com.lark.oapi.service.block.v2.BlockService;
import com.lark.oapi.service.calendar.v4.CalendarService;
import com.lark.oapi.service.contact.v3.ContactService;
import com.lark.oapi.service.corehr.v1.CorehrService;
import com.lark.oapi.service.docx.v1.DocxService;
import com.lark.oapi.service.drive.v1.DriveService;
import com.lark.oapi.service.ehr.v1.EhrService;
import com.lark.oapi.service.event.v1.EventService;
import com.lark.oapi.service.ext.ExtService;
import com.lark.oapi.service.gray_test_open_sg.v1.GrayTestOpenSgService;
import com.lark.oapi.service.helpdesk.v1.HelpdeskService;
import com.lark.oapi.service.hire.v1.HireService;
import com.lark.oapi.service.human_authentication.v1.HumanAuthenticationService;
import com.lark.oapi.service.im.v1.ImService;
import com.lark.oapi.service.mail.v1.MailService;
import com.lark.oapi.service.meeting_room.v1.MeetingRoomService;
import com.lark.oapi.service.okr.v1.OkrService;
import com.lark.oapi.service.optical_char_recognition.v1.OpticalCharRecognitionService;
import com.lark.oapi.service.passport.v1.PassportService;
import com.lark.oapi.service.search.v2.SearchService;
import com.lark.oapi.service.sheets.v3.SheetsService;
import com.lark.oapi.service.speech_to_text.v1.SpeechToTextService;
import com.lark.oapi.service.task.v1.TaskService;
import com.lark.oapi.service.tenant.v2.TenantService;
import com.lark.oapi.service.translation.v1.TranslationService;
import com.lark.oapi.service.vc.v1.VcService;
import com.lark.oapi.service.wiki.v2.WikiService;

/**
 * 该包装类的作用主要是为了便于扩展 Client尚未提供的接口
 *
 * @author Getouo(梁圣贤) on 2023/7/12
 * @see Client
 */
public class ClientWrapper extends Client {

    private Client client;

    public ClientWrapper(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("client cannot be null.");
        }
        this.client = client;
    }

    protected Client _getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("client cannot be null.");
        }
        this.client = client;
    }

    @Override
    public ExtService ext() {
        return this._getClient().ext();
    }

    @Override
    public void setConfig(Config config) {
        this._getClient().setConfig(config);
    }

    @Override
    public AcsService acs() {
        return this._getClient().acs();
    }

    @Override
    public AdminService admin() {
        return this._getClient().admin();
    }

    @Override
    public ApplicationService application() {
        return this._getClient().application();
    }

    @Override
    public ApprovalService approval() {
        return this._getClient().approval();
    }

    @Override
    public AttendanceService attendance() {
        return this._getClient().attendance();
    }

    @Override
    public AuthService auth() {
        return this._getClient().auth();
    }

    @Override
    public AuthenService authen() {
        return this._getClient().authen();
    }

    @Override
    public BaikeService baike() {
        return this._getClient().baike();
    }

    @Override
    public BitableService bitable() {
        return this._getClient().bitable();
    }

    @Override
    public BlockService block() {
        return this._getClient().block();
    }

    @Override
    public CalendarService calendar() {
        return this._getClient().calendar();
    }

    @Override
    public ContactService contact() {
        return this._getClient().contact();
    }

    @Override
    public CorehrService corehr() {
        return this._getClient().corehr();
    }

    @Override
    public DocxService docx() {
        return this._getClient().docx();
    }

    @Override
    public DriveService drive() {
        return this._getClient().drive();
    }

    @Override
    public EhrService ehr() {
        return this._getClient().ehr();
    }

    @Override
    public EventService event() {
        return this._getClient().event();
    }

    @Override
    public GrayTestOpenSgService grayTestOpenSg() {
        return this._getClient().grayTestOpenSg();
    }

    @Override
    public HelpdeskService helpdesk() {
        return this._getClient().helpdesk();
    }

    @Override
    public HireService hire() {
        return this._getClient().hire();
    }

    @Override
    public HumanAuthenticationService humanAuthentication() {
        return this._getClient().humanAuthentication();
    }

    @Override
    public ImService im() {
        return this._getClient().im();
    }

    @Override
    public MailService mail() {
        return this._getClient().mail();
    }

    @Override
    public MeetingRoomService meetingRoom() {
        return this._getClient().meetingRoom();
    }

    @Override
    public OkrService okr() {
        return this._getClient().okr();
    }

    @Override
    public OpticalCharRecognitionService opticalCharRecognition() {
        return this._getClient().opticalCharRecognition();
    }

    @Override
    public PassportService passport() {
        return this._getClient().passport();
    }

    @Override
    public SearchService search() {
        return this._getClient().search();
    }

    @Override
    public SheetsService sheets() {
        return this._getClient().sheets();
    }

    @Override
    public SpeechToTextService speechToText() {
        return this._getClient().speechToText();
    }

    @Override
    public TaskService task() {
        return this._getClient().task();
    }

    @Override
    public TenantService tenant() {
        return this._getClient().tenant();
    }

    @Override
    public TranslationService translation() {
        return this._getClient().translation();
    }

    @Override
    public VcService vc() {
        return this._getClient().vc();
    }

    @Override
    public WikiService wiki() {
        return this._getClient().wiki();
    }

    @Override
    public RawResponse post(String httpPath, Object body, AccessTokenType accessTokenType, RequestOptions requestOptions) throws Exception {
        return this._getClient().post(httpPath, body, accessTokenType, requestOptions);
    }

    @Override
    public RawResponse post(String httpPath, Object body, AccessTokenType accessTokenType) throws Exception {
        return this._getClient().post(httpPath, body, accessTokenType);
    }

    @Override
    public RawResponse get(String httpPath, Object body, AccessTokenType accessTokenType, RequestOptions requestOptions) throws Exception {
        return this._getClient().get(httpPath, body, accessTokenType, requestOptions);
    }

    @Override
    public RawResponse get(String httpPath, Object body, AccessTokenType accessTokenType) throws Exception {
        return this._getClient().get(httpPath, body, accessTokenType);
    }

    @Override
    public RawResponse delete(String httpPath, Object body, AccessTokenType accessTokenType, RequestOptions requestOptions) throws Exception {
        return this._getClient().delete(httpPath, body, accessTokenType, requestOptions);
    }

    @Override
    public RawResponse delete(String httpPath, Object body, AccessTokenType accessTokenType) throws Exception {
        return this._getClient().delete(httpPath, body, accessTokenType);
    }

    @Override
    public RawResponse put(String httpPath, Object body, AccessTokenType accessTokenType, RequestOptions requestOptions) throws Exception {
        return this._getClient().put(httpPath, body, accessTokenType, requestOptions);
    }

    @Override
    public RawResponse put(String httpPath, Object body, AccessTokenType accessTokenType) throws Exception {
        return this._getClient().put(httpPath, body, accessTokenType);
    }

    @Override
    public RawResponse patch(String httpPath, Object body, AccessTokenType accessTokenType, RequestOptions requestOptions) throws Exception {
        return this._getClient().patch(httpPath, body, accessTokenType, requestOptions);
    }

    @Override
    public RawResponse patch(String httpPath, Object body, AccessTokenType accessTokenType) throws Exception {
        return this._getClient().patch(httpPath, body, accessTokenType);
    }

    @Override
    public RawResponse options(String httpPath, Object body, AccessTokenType accessTokenType, RequestOptions requestOptions) throws Exception {
        return this._getClient().options(httpPath, body, accessTokenType, requestOptions);
    }

    @Override
    public RawResponse options(String httpPath, Object body, AccessTokenType accessTokenType) throws Exception {
        return this._getClient().options(httpPath, body, accessTokenType);
    }
}
