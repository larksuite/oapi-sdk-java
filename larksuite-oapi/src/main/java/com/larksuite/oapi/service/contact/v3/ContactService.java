// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.contact.v3;

import com.larksuite.oapi.core.api.AccessTokenType;
import com.larksuite.oapi.core.api.Api;
import com.larksuite.oapi.core.api.ReqCaller;
import com.larksuite.oapi.core.api.request.*;
import com.larksuite.oapi.core.api.response.*;
import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.event.Event;
import com.larksuite.oapi.core.event.IHandler;
import com.larksuite.oapi.service.contact.v3.model.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ContactService {

    private final Config config;
    private final Users users;
    private final UserGroups userGroups;
    private final Departments departments;
    private final Scopes scopes;
    private final CustomAttrEvents customAttrEvents;
    private final EmployeeTypeEnums employeeTypeEnums;

    public ContactService(Config config) {
        this.config = config;
        this.users = new Users(this);
        this.userGroups = new UserGroups(this);
        this.departments = new Departments(this);
        this.scopes = new Scopes(this);
        this.customAttrEvents = new CustomAttrEvents(this);
        this.employeeTypeEnums = new EmployeeTypeEnums(this);
    }

    public Users getUsers() {
        return users;
    }

    public static class Users {

        private final ContactService service;

        public Users(ContactService service) {
            this.service = service;
        }
    
        public UserDeleteReqCall delete(UserDeleteReqBody body, RequestOptFn... optFns) {
            return new UserDeleteReqCall(this, body, optFns);
        }
    
        public UserUpdateReqCall update(User body, RequestOptFn... optFns) {
            return new UserUpdateReqCall(this, body, optFns);
        }
    
        public UserCreateReqCall create(User body, RequestOptFn... optFns) {
            return new UserCreateReqCall(this, body, optFns);
        }
    
        public UserPatchReqCall patch(User body, RequestOptFn... optFns) {
            return new UserPatchReqCall(this, body, optFns);
        }
    
        public UserGetReqCall get(RequestOptFn... optFns) {
            return new UserGetReqCall(this, optFns);
        }
    
        public UserListReqCall list(RequestOptFn... optFns) {
            return new UserListReqCall(this, optFns);
        }
    
    }
    public static class UserDeleteReqCall extends ReqCaller<UserDeleteReqBody, EmptyData> {
        private final Users users;
        
        private final UserDeleteReqBody body;
        private final Map<String, Object> pathParams;
        private final Map<String, Object> queryParams;
        private final List<RequestOptFn> optFns;
        private EmptyData result;
        
        private UserDeleteReqCall(Users users, UserDeleteReqBody body, RequestOptFn... optFns) {
        
            this.body = body;
            this.pathParams = new HashMap<>();
            this.queryParams = new HashMap<>();
            this.optFns = new ArrayList<>();
            this.optFns.addAll(Arrays.asList(optFns));
            this.result = new EmptyData();
            this.users = users;
        }
        
        public UserDeleteReqCall setUserId(String userId){
            this.pathParams.put("user_id", userId);
            return this;
        }
        
        public UserDeleteReqCall setUserIdType(String userIdType){
            this.queryParams.put("user_id_type", userIdType);
            return this;
        }

        @Override
        public Response<EmptyData> execute() throws Exception {
            this.optFns.add(Request.setPathParams(this.pathParams));
            this.optFns.add(Request.setQueryParams(this.queryParams));
            Request<UserDeleteReqBody, EmptyData> request = Request.newRequest("contact/v3/users/:user_id", "DELETE",
                    new AccessTokenType[]{AccessTokenType.Tenant},
                    this.body, this.result, this.optFns.toArray(new RequestOptFn[]{}));
            return Api.send(this.users.service.config, request);
        }
    }
    public static class UserUpdateReqCall extends ReqCaller<User, UserUpdateResult> {
        private final Users users;
        
        private final User body;
        private final Map<String, Object> pathParams;
        private final Map<String, Object> queryParams;
        private final List<RequestOptFn> optFns;
        private UserUpdateResult result;
        
        private UserUpdateReqCall(Users users, User body, RequestOptFn... optFns) {
        
            this.body = body;
            this.pathParams = new HashMap<>();
            this.queryParams = new HashMap<>();
            this.optFns = new ArrayList<>();
            this.optFns.addAll(Arrays.asList(optFns));
            this.result = new UserUpdateResult();
            this.users = users;
        }
        
        public UserUpdateReqCall setUserId(String userId){
            this.pathParams.put("user_id", userId);
            return this;
        }
        
        public UserUpdateReqCall setUserIdType(String userIdType){
            this.queryParams.put("user_id_type", userIdType);
            return this;
        }
        public UserUpdateReqCall setDepartmentIdType(String departmentIdType){
            this.queryParams.put("department_id_type", departmentIdType);
            return this;
        }

        @Override
        public Response<UserUpdateResult> execute() throws Exception {
            this.optFns.add(Request.setPathParams(this.pathParams));
            this.optFns.add(Request.setQueryParams(this.queryParams));
            Request<User, UserUpdateResult> request = Request.newRequest("contact/v3/users/:user_id", "PUT",
                    new AccessTokenType[]{AccessTokenType.Tenant},
                    this.body, this.result, this.optFns.toArray(new RequestOptFn[]{}));
            return Api.send(this.users.service.config, request);
        }
    }
    public static class UserCreateReqCall extends ReqCaller<User, UserCreateResult> {
        private final Users users;
        
        private final User body;
        private final Map<String, Object> queryParams;
        private final List<RequestOptFn> optFns;
        private UserCreateResult result;
        
        private UserCreateReqCall(Users users, User body, RequestOptFn... optFns) {
        
            this.body = body;
            this.queryParams = new HashMap<>();
            this.optFns = new ArrayList<>();
            this.optFns.addAll(Arrays.asList(optFns));
            this.result = new UserCreateResult();
            this.users = users;
        }
        
        
        public UserCreateReqCall setUserIdType(String userIdType){
            this.queryParams.put("user_id_type", userIdType);
            return this;
        }
        public UserCreateReqCall setDepartmentIdType(String departmentIdType){
            this.queryParams.put("department_id_type", departmentIdType);
            return this;
        }
        public UserCreateReqCall setClientToken(String clientToken){
            this.queryParams.put("client_token", clientToken);
            return this;
        }

        @Override
        public Response<UserCreateResult> execute() throws Exception {
            this.optFns.add(Request.setQueryParams(this.queryParams));
            Request<User, UserCreateResult> request = Request.newRequest("contact/v3/users", "POST",
                    new AccessTokenType[]{AccessTokenType.Tenant},
                    this.body, this.result, this.optFns.toArray(new RequestOptFn[]{}));
            return Api.send(this.users.service.config, request);
        }
    }
    public static class UserPatchReqCall extends ReqCaller<User, UserPatchResult> {
        private final Users users;
        
        private final User body;
        private final Map<String, Object> pathParams;
        private final Map<String, Object> queryParams;
        private final List<RequestOptFn> optFns;
        private UserPatchResult result;
        
        private UserPatchReqCall(Users users, User body, RequestOptFn... optFns) {
        
            this.body = body;
            this.pathParams = new HashMap<>();
            this.queryParams = new HashMap<>();
            this.optFns = new ArrayList<>();
            this.optFns.addAll(Arrays.asList(optFns));
            this.result = new UserPatchResult();
            this.users = users;
        }
        
        public UserPatchReqCall setUserId(String userId){
            this.pathParams.put("user_id", userId);
            return this;
        }
        
        public UserPatchReqCall setUserIdType(String userIdType){
            this.queryParams.put("user_id_type", userIdType);
            return this;
        }
        public UserPatchReqCall setDepartmentIdType(String departmentIdType){
            this.queryParams.put("department_id_type", departmentIdType);
            return this;
        }

        @Override
        public Response<UserPatchResult> execute() throws Exception {
            this.optFns.add(Request.setPathParams(this.pathParams));
            this.optFns.add(Request.setQueryParams(this.queryParams));
            Request<User, UserPatchResult> request = Request.newRequest("contact/v3/users/:user_id", "PATCH",
                    new AccessTokenType[]{AccessTokenType.Tenant, AccessTokenType.User},
                    this.body, this.result, this.optFns.toArray(new RequestOptFn[]{}));
            return Api.send(this.users.service.config, request);
        }
    }
    public static class UserGetReqCall extends ReqCaller<Object, UserGetResult> {
        private final Users users;
        
        private final Map<String, Object> pathParams;
        private final Map<String, Object> queryParams;
        private final List<RequestOptFn> optFns;
        private UserGetResult result;
        
        private UserGetReqCall(Users users, RequestOptFn... optFns) {
        
            this.pathParams = new HashMap<>();
            this.queryParams = new HashMap<>();
            this.optFns = new ArrayList<>();
            this.optFns.addAll(Arrays.asList(optFns));
            this.result = new UserGetResult();
            this.users = users;
        }
        
        public UserGetReqCall setUserId(String userId){
            this.pathParams.put("user_id", userId);
            return this;
        }
        
        public UserGetReqCall setUserIdType(String userIdType){
            this.queryParams.put("user_id_type", userIdType);
            return this;
        }
        public UserGetReqCall setDepartmentIdType(String departmentIdType){
            this.queryParams.put("department_id_type", departmentIdType);
            return this;
        }

        @Override
        public Response<UserGetResult> execute() throws Exception {
            this.optFns.add(Request.setPathParams(this.pathParams));
            this.optFns.add(Request.setQueryParams(this.queryParams));
            Request<Object, UserGetResult> request = Request.newRequest("contact/v3/users/:user_id", "GET",
                    new AccessTokenType[]{AccessTokenType.Tenant, AccessTokenType.User},
                    null, this.result, this.optFns.toArray(new RequestOptFn[]{}));
            return Api.send(this.users.service.config, request);
        }
    }
    public static class UserListReqCall extends ReqCaller<Object, UserListResult> {
        private final Users users;
        
        private final Map<String, Object> queryParams;
        private final List<RequestOptFn> optFns;
        private UserListResult result;
        
        private UserListReqCall(Users users, RequestOptFn... optFns) {
        
            this.queryParams = new HashMap<>();
            this.optFns = new ArrayList<>();
            this.optFns.addAll(Arrays.asList(optFns));
            this.result = new UserListResult();
            this.users = users;
        }
        
        
        public UserListReqCall setUserIdType(String userIdType){
            this.queryParams.put("user_id_type", userIdType);
            return this;
        }
        public UserListReqCall setDepartmentIdType(String departmentIdType){
            this.queryParams.put("department_id_type", departmentIdType);
            return this;
        }
        public UserListReqCall setDepartmentId(String departmentId){
            this.queryParams.put("department_id", departmentId);
            return this;
        }
        public UserListReqCall setPageToken(String pageToken){
            this.queryParams.put("page_token", pageToken);
            return this;
        }
        public UserListReqCall setPageSize(Integer pageSize){
            this.queryParams.put("page_size", pageSize);
            return this;
        }

        @Override
        public Response<UserListResult> execute() throws Exception {
            this.optFns.add(Request.setQueryParams(this.queryParams));
            Request<Object, UserListResult> request = Request.newRequest("contact/v3/users", "GET",
                    new AccessTokenType[]{AccessTokenType.Tenant, AccessTokenType.User},
                    null, this.result, this.optFns.toArray(new RequestOptFn[]{}));
            return Api.send(this.users.service.config, request);
        }
    }

    public UserGroups getUserGroups() {
        return userGroups;
    }

    public static class UserGroups {

        private final ContactService service;

        public UserGroups(ContactService service) {
            this.service = service;
        }
    
    }

    public Departments getDepartments() {
        return departments;
    }

    public static class Departments {

        private final ContactService service;

        public Departments(ContactService service) {
            this.service = service;
        }
    
        public DepartmentGetReqCall get(RequestOptFn... optFns) {
            return new DepartmentGetReqCall(this, optFns);
        }
    
        public DepartmentListReqCall list(RequestOptFn... optFns) {
            return new DepartmentListReqCall(this, optFns);
        }
    
        public DepartmentPatchReqCall patch(Department body, RequestOptFn... optFns) {
            return new DepartmentPatchReqCall(this, body, optFns);
        }
    
        public DepartmentCreateReqCall create(Department body, RequestOptFn... optFns) {
            return new DepartmentCreateReqCall(this, body, optFns);
        }
    
        public DepartmentDeleteReqCall delete(RequestOptFn... optFns) {
            return new DepartmentDeleteReqCall(this, optFns);
        }
    
        public DepartmentUpdateReqCall update(Department body, RequestOptFn... optFns) {
            return new DepartmentUpdateReqCall(this, body, optFns);
        }
    
        public DepartmentParentReqCall parent(RequestOptFn... optFns) {
            return new DepartmentParentReqCall(this, optFns);
        }
    
        public DepartmentSearchReqCall search(DepartmentSearchReqBody body, RequestOptFn... optFns) {
            return new DepartmentSearchReqCall(this, body, optFns);
        }
    
    }
    public static class DepartmentGetReqCall extends ReqCaller<Object, DepartmentGetResult> {
        private final Departments departments;
        
        private final Map<String, Object> pathParams;
        private final Map<String, Object> queryParams;
        private final List<RequestOptFn> optFns;
        private DepartmentGetResult result;
        
        private DepartmentGetReqCall(Departments departments, RequestOptFn... optFns) {
        
            this.pathParams = new HashMap<>();
            this.queryParams = new HashMap<>();
            this.optFns = new ArrayList<>();
            this.optFns.addAll(Arrays.asList(optFns));
            this.result = new DepartmentGetResult();
            this.departments = departments;
        }
        
        public DepartmentGetReqCall setDepartmentId(String departmentId){
            this.pathParams.put("department_id", departmentId);
            return this;
        }
        
        public DepartmentGetReqCall setUserIdType(String userIdType){
            this.queryParams.put("user_id_type", userIdType);
            return this;
        }
        public DepartmentGetReqCall setDepartmentIdType(String departmentIdType){
            this.queryParams.put("department_id_type", departmentIdType);
            return this;
        }

        @Override
        public Response<DepartmentGetResult> execute() throws Exception {
            this.optFns.add(Request.setPathParams(this.pathParams));
            this.optFns.add(Request.setQueryParams(this.queryParams));
            Request<Object, DepartmentGetResult> request = Request.newRequest("contact/v3/departments/:department_id", "GET",
                    new AccessTokenType[]{AccessTokenType.Tenant, AccessTokenType.User},
                    null, this.result, this.optFns.toArray(new RequestOptFn[]{}));
            return Api.send(this.departments.service.config, request);
        }
    }
    public static class DepartmentListReqCall extends ReqCaller<Object, DepartmentListResult> {
        private final Departments departments;
        
        private final Map<String, Object> queryParams;
        private final List<RequestOptFn> optFns;
        private DepartmentListResult result;
        
        private DepartmentListReqCall(Departments departments, RequestOptFn... optFns) {
        
            this.queryParams = new HashMap<>();
            this.optFns = new ArrayList<>();
            this.optFns.addAll(Arrays.asList(optFns));
            this.result = new DepartmentListResult();
            this.departments = departments;
        }
        
        
        public DepartmentListReqCall setUserIdType(String userIdType){
            this.queryParams.put("user_id_type", userIdType);
            return this;
        }
        public DepartmentListReqCall setDepartmentIdType(String departmentIdType){
            this.queryParams.put("department_id_type", departmentIdType);
            return this;
        }
        public DepartmentListReqCall setParentDepartmentId(String parentDepartmentId){
            this.queryParams.put("parent_department_id", parentDepartmentId);
            return this;
        }
        public DepartmentListReqCall setFetchChild(Boolean fetchChild){
            this.queryParams.put("fetch_child", fetchChild);
            return this;
        }
        public DepartmentListReqCall setPageToken(String pageToken){
            this.queryParams.put("page_token", pageToken);
            return this;
        }
        public DepartmentListReqCall setPageSize(Integer pageSize){
            this.queryParams.put("page_size", pageSize);
            return this;
        }

        @Override
        public Response<DepartmentListResult> execute() throws Exception {
            this.optFns.add(Request.setQueryParams(this.queryParams));
            Request<Object, DepartmentListResult> request = Request.newRequest("contact/v3/departments", "GET",
                    new AccessTokenType[]{AccessTokenType.Tenant, AccessTokenType.User},
                    null, this.result, this.optFns.toArray(new RequestOptFn[]{}));
            return Api.send(this.departments.service.config, request);
        }
    }
    public static class DepartmentPatchReqCall extends ReqCaller<Department, DepartmentPatchResult> {
        private final Departments departments;
        
        private final Department body;
        private final Map<String, Object> pathParams;
        private final Map<String, Object> queryParams;
        private final List<RequestOptFn> optFns;
        private DepartmentPatchResult result;
        
        private DepartmentPatchReqCall(Departments departments, Department body, RequestOptFn... optFns) {
        
            this.body = body;
            this.pathParams = new HashMap<>();
            this.queryParams = new HashMap<>();
            this.optFns = new ArrayList<>();
            this.optFns.addAll(Arrays.asList(optFns));
            this.result = new DepartmentPatchResult();
            this.departments = departments;
        }
        
        public DepartmentPatchReqCall setDepartmentId(String departmentId){
            this.pathParams.put("department_id", departmentId);
            return this;
        }
        
        public DepartmentPatchReqCall setUserIdType(String userIdType){
            this.queryParams.put("user_id_type", userIdType);
            return this;
        }
        public DepartmentPatchReqCall setDepartmentIdType(String departmentIdType){
            this.queryParams.put("department_id_type", departmentIdType);
            return this;
        }

        @Override
        public Response<DepartmentPatchResult> execute() throws Exception {
            this.optFns.add(Request.setPathParams(this.pathParams));
            this.optFns.add(Request.setQueryParams(this.queryParams));
            Request<Department, DepartmentPatchResult> request = Request.newRequest("contact/v3/departments/:department_id", "PATCH",
                    new AccessTokenType[]{AccessTokenType.Tenant},
                    this.body, this.result, this.optFns.toArray(new RequestOptFn[]{}));
            return Api.send(this.departments.service.config, request);
        }
    }
    public static class DepartmentCreateReqCall extends ReqCaller<Department, DepartmentCreateResult> {
        private final Departments departments;
        
        private final Department body;
        private final Map<String, Object> queryParams;
        private final List<RequestOptFn> optFns;
        private DepartmentCreateResult result;
        
        private DepartmentCreateReqCall(Departments departments, Department body, RequestOptFn... optFns) {
        
            this.body = body;
            this.queryParams = new HashMap<>();
            this.optFns = new ArrayList<>();
            this.optFns.addAll(Arrays.asList(optFns));
            this.result = new DepartmentCreateResult();
            this.departments = departments;
        }
        
        
        public DepartmentCreateReqCall setUserIdType(String userIdType){
            this.queryParams.put("user_id_type", userIdType);
            return this;
        }
        public DepartmentCreateReqCall setDepartmentIdType(String departmentIdType){
            this.queryParams.put("department_id_type", departmentIdType);
            return this;
        }
        public DepartmentCreateReqCall setClientToken(String clientToken){
            this.queryParams.put("client_token", clientToken);
            return this;
        }

        @Override
        public Response<DepartmentCreateResult> execute() throws Exception {
            this.optFns.add(Request.setQueryParams(this.queryParams));
            Request<Department, DepartmentCreateResult> request = Request.newRequest("contact/v3/departments", "POST",
                    new AccessTokenType[]{AccessTokenType.Tenant},
                    this.body, this.result, this.optFns.toArray(new RequestOptFn[]{}));
            return Api.send(this.departments.service.config, request);
        }
    }
    public static class DepartmentDeleteReqCall extends ReqCaller<Object, EmptyData> {
        private final Departments departments;
        
        private final Map<String, Object> pathParams;
        private final Map<String, Object> queryParams;
        private final List<RequestOptFn> optFns;
        private EmptyData result;
        
        private DepartmentDeleteReqCall(Departments departments, RequestOptFn... optFns) {
        
            this.pathParams = new HashMap<>();
            this.queryParams = new HashMap<>();
            this.optFns = new ArrayList<>();
            this.optFns.addAll(Arrays.asList(optFns));
            this.result = new EmptyData();
            this.departments = departments;
        }
        
        public DepartmentDeleteReqCall setDepartmentId(String departmentId){
            this.pathParams.put("department_id", departmentId);
            return this;
        }
        
        public DepartmentDeleteReqCall setDepartmentIdType(String departmentIdType){
            this.queryParams.put("department_id_type", departmentIdType);
            return this;
        }

        @Override
        public Response<EmptyData> execute() throws Exception {
            this.optFns.add(Request.setPathParams(this.pathParams));
            this.optFns.add(Request.setQueryParams(this.queryParams));
            Request<Object, EmptyData> request = Request.newRequest("contact/v3/departments/:department_id", "DELETE",
                    new AccessTokenType[]{AccessTokenType.Tenant},
                    null, this.result, this.optFns.toArray(new RequestOptFn[]{}));
            return Api.send(this.departments.service.config, request);
        }
    }
    public static class DepartmentUpdateReqCall extends ReqCaller<Department, DepartmentUpdateResult> {
        private final Departments departments;
        
        private final Department body;
        private final Map<String, Object> pathParams;
        private final Map<String, Object> queryParams;
        private final List<RequestOptFn> optFns;
        private DepartmentUpdateResult result;
        
        private DepartmentUpdateReqCall(Departments departments, Department body, RequestOptFn... optFns) {
        
            this.body = body;
            this.pathParams = new HashMap<>();
            this.queryParams = new HashMap<>();
            this.optFns = new ArrayList<>();
            this.optFns.addAll(Arrays.asList(optFns));
            this.result = new DepartmentUpdateResult();
            this.departments = departments;
        }
        
        public DepartmentUpdateReqCall setDepartmentId(String departmentId){
            this.pathParams.put("department_id", departmentId);
            return this;
        }
        
        public DepartmentUpdateReqCall setUserIdType(String userIdType){
            this.queryParams.put("user_id_type", userIdType);
            return this;
        }
        public DepartmentUpdateReqCall setDepartmentIdType(String departmentIdType){
            this.queryParams.put("department_id_type", departmentIdType);
            return this;
        }

        @Override
        public Response<DepartmentUpdateResult> execute() throws Exception {
            this.optFns.add(Request.setPathParams(this.pathParams));
            this.optFns.add(Request.setQueryParams(this.queryParams));
            Request<Department, DepartmentUpdateResult> request = Request.newRequest("contact/v3/departments/:department_id", "PUT",
                    new AccessTokenType[]{AccessTokenType.Tenant},
                    this.body, this.result, this.optFns.toArray(new RequestOptFn[]{}));
            return Api.send(this.departments.service.config, request);
        }
    }
    public static class DepartmentParentReqCall extends ReqCaller<Object, DepartmentParentResult> {
        private final Departments departments;
        
        private final Map<String, Object> queryParams;
        private final List<RequestOptFn> optFns;
        private DepartmentParentResult result;
        
        private DepartmentParentReqCall(Departments departments, RequestOptFn... optFns) {
        
            this.queryParams = new HashMap<>();
            this.optFns = new ArrayList<>();
            this.optFns.addAll(Arrays.asList(optFns));
            this.result = new DepartmentParentResult();
            this.departments = departments;
        }
        
        
        public DepartmentParentReqCall setUserIdType(String userIdType){
            this.queryParams.put("user_id_type", userIdType);
            return this;
        }
        public DepartmentParentReqCall setDepartmentIdType(String departmentIdType){
            this.queryParams.put("department_id_type", departmentIdType);
            return this;
        }
        public DepartmentParentReqCall setDepartmentId(String departmentId){
            this.queryParams.put("department_id", departmentId);
            return this;
        }
        public DepartmentParentReqCall setPageToken(String pageToken){
            this.queryParams.put("page_token", pageToken);
            return this;
        }
        public DepartmentParentReqCall setPageSize(Integer pageSize){
            this.queryParams.put("page_size", pageSize);
            return this;
        }

        @Override
        public Response<DepartmentParentResult> execute() throws Exception {
            this.optFns.add(Request.setQueryParams(this.queryParams));
            Request<Object, DepartmentParentResult> request = Request.newRequest("contact/v3/departments/parent", "GET",
                    new AccessTokenType[]{AccessTokenType.Tenant, AccessTokenType.User},
                    null, this.result, this.optFns.toArray(new RequestOptFn[]{}));
            return Api.send(this.departments.service.config, request);
        }
    }
    public static class DepartmentSearchReqCall extends ReqCaller<DepartmentSearchReqBody, DepartmentSearchResult> {
        private final Departments departments;
        
        private final DepartmentSearchReqBody body;
        private final Map<String, Object> queryParams;
        private final List<RequestOptFn> optFns;
        private DepartmentSearchResult result;
        
        private DepartmentSearchReqCall(Departments departments, DepartmentSearchReqBody body, RequestOptFn... optFns) {
        
            this.body = body;
            this.queryParams = new HashMap<>();
            this.optFns = new ArrayList<>();
            this.optFns.addAll(Arrays.asList(optFns));
            this.result = new DepartmentSearchResult();
            this.departments = departments;
        }
        
        
        public DepartmentSearchReqCall setUserIdType(String userIdType){
            this.queryParams.put("user_id_type", userIdType);
            return this;
        }
        public DepartmentSearchReqCall setDepartmentIdType(String departmentIdType){
            this.queryParams.put("department_id_type", departmentIdType);
            return this;
        }
        public DepartmentSearchReqCall setPageToken(String pageToken){
            this.queryParams.put("page_token", pageToken);
            return this;
        }
        public DepartmentSearchReqCall setPageSize(Integer pageSize){
            this.queryParams.put("page_size", pageSize);
            return this;
        }

        @Override
        public Response<DepartmentSearchResult> execute() throws Exception {
            this.optFns.add(Request.setQueryParams(this.queryParams));
            Request<DepartmentSearchReqBody, DepartmentSearchResult> request = Request.newRequest("contact/v3/departments/search", "POST",
                    new AccessTokenType[]{AccessTokenType.User},
                    this.body, this.result, this.optFns.toArray(new RequestOptFn[]{}));
            return Api.send(this.departments.service.config, request);
        }
    }

    public Scopes getScopes() {
        return scopes;
    }

    public static class Scopes {

        private final ContactService service;

        public Scopes(ContactService service) {
            this.service = service;
        }
    
    }

    public CustomAttrEvents getCustomAttrEvents() {
        return customAttrEvents;
    }

    public static class CustomAttrEvents {

        private final ContactService service;

        public CustomAttrEvents(ContactService service) {
            this.service = service;
        }
    
    }

    public EmployeeTypeEnums getEmployeeTypeEnums() {
        return employeeTypeEnums;
    }

    public static class EmployeeTypeEnums {

        private final ContactService service;

        public EmployeeTypeEnums(ContactService service) {
            this.service = service;
        }
    
    }
    public void setDepartmentCreatedEventHandler(DepartmentCreatedEventHandler handler) {
        Event.setTypeHandler(this.config, "contact.department.created_v3", handler);
    }

    public abstract static class DepartmentCreatedEventHandler implements IHandler<DepartmentCreatedEvent> {
        @Override
        public DepartmentCreatedEvent getEvent() {
            return new DepartmentCreatedEvent();
        }
    }
    public void setDepartmentDeletedEventHandler(DepartmentDeletedEventHandler handler) {
        Event.setTypeHandler(this.config, "contact.department.deleted_v3", handler);
    }

    public abstract static class DepartmentDeletedEventHandler implements IHandler<DepartmentDeletedEvent> {
        @Override
        public DepartmentDeletedEvent getEvent() {
            return new DepartmentDeletedEvent();
        }
    }
    public void setDepartmentUpdatedEventHandler(DepartmentUpdatedEventHandler handler) {
        Event.setTypeHandler(this.config, "contact.department.updated_v3", handler);
    }

    public abstract static class DepartmentUpdatedEventHandler implements IHandler<DepartmentUpdatedEvent> {
        @Override
        public DepartmentUpdatedEvent getEvent() {
            return new DepartmentUpdatedEvent();
        }
    }
    public void setUserCreatedEventHandler(UserCreatedEventHandler handler) {
        Event.setTypeHandler(this.config, "contact.user.created_v3", handler);
    }

    public abstract static class UserCreatedEventHandler implements IHandler<UserCreatedEvent> {
        @Override
        public UserCreatedEvent getEvent() {
            return new UserCreatedEvent();
        }
    }
    public void setUserDeletedEventHandler(UserDeletedEventHandler handler) {
        Event.setTypeHandler(this.config, "contact.user.deleted_v3", handler);
    }

    public abstract static class UserDeletedEventHandler implements IHandler<UserDeletedEvent> {
        @Override
        public UserDeletedEvent getEvent() {
            return new UserDeletedEvent();
        }
    }
    public void setUserUpdatedEventHandler(UserUpdatedEventHandler handler) {
        Event.setTypeHandler(this.config, "contact.user.updated_v3", handler);
    }

    public abstract static class UserUpdatedEventHandler implements IHandler<UserUpdatedEvent> {
        @Override
        public UserUpdatedEvent getEvent() {
            return new UserUpdatedEvent();
        }
    }
    public void setUserGroupCreatedEventHandler(UserGroupCreatedEventHandler handler) {
        Event.setTypeHandler(this.config, "contact.user_group.created_v3", handler);
    }

    public abstract static class UserGroupCreatedEventHandler implements IHandler<UserGroupCreatedEvent> {
        @Override
        public UserGroupCreatedEvent getEvent() {
            return new UserGroupCreatedEvent();
        }
    }
    public void setUserGroupDeletedEventHandler(UserGroupDeletedEventHandler handler) {
        Event.setTypeHandler(this.config, "contact.user_group.deleted_v3", handler);
    }

    public abstract static class UserGroupDeletedEventHandler implements IHandler<UserGroupDeletedEvent> {
        @Override
        public UserGroupDeletedEvent getEvent() {
            return new UserGroupDeletedEvent();
        }
    }
    public void setUserGroupUpdatedEventHandler(UserGroupUpdatedEventHandler handler) {
        Event.setTypeHandler(this.config, "contact.user_group.updated_v3", handler);
    }

    public abstract static class UserGroupUpdatedEventHandler implements IHandler<UserGroupUpdatedEvent> {
        @Override
        public UserGroupUpdatedEvent getEvent() {
            return new UserGroupUpdatedEvent();
        }
    }
    public void setScopeUpdatedEventHandler(ScopeUpdatedEventHandler handler) {
        Event.setTypeHandler(this.config, "contact.scope.updated_v3", handler);
    }

    public abstract static class ScopeUpdatedEventHandler implements IHandler<ScopeUpdatedEvent> {
        @Override
        public ScopeUpdatedEvent getEvent() {
            return new ScopeUpdatedEvent();
        }
    }
    public void setUserGroupMemberChangedEventHandler(UserGroupMemberChangedEventHandler handler) {
        Event.setTypeHandler(this.config, "contact.user_group.member.changed_v3", handler);
    }

    public abstract static class UserGroupMemberChangedEventHandler implements IHandler<UserGroupMemberChangedEvent> {
        @Override
        public UserGroupMemberChangedEvent getEvent() {
            return new UserGroupMemberChangedEvent();
        }
    }
    public void setCustomAttrEventUpdatedEventHandler(CustomAttrEventUpdatedEventHandler handler) {
        Event.setTypeHandler(this.config, "contact.custom_attr_event.updated_v3", handler);
    }

    public abstract static class CustomAttrEventUpdatedEventHandler implements IHandler<CustomAttrEventUpdatedEvent> {
        @Override
        public CustomAttrEventUpdatedEvent getEvent() {
            return new CustomAttrEventUpdatedEvent();
        }
    }
    public void setEmployeeTypeEnumActivedEventHandler(EmployeeTypeEnumActivedEventHandler handler) {
        Event.setTypeHandler(this.config, "contact.employee_type_enum.actived_v3", handler);
    }

    public abstract static class EmployeeTypeEnumActivedEventHandler implements IHandler<EmployeeTypeEnumActivedEvent> {
        @Override
        public EmployeeTypeEnumActivedEvent getEvent() {
            return new EmployeeTypeEnumActivedEvent();
        }
    }
    public void setEmployeeTypeEnumCreatedEventHandler(EmployeeTypeEnumCreatedEventHandler handler) {
        Event.setTypeHandler(this.config, "contact.employee_type_enum.created_v3", handler);
    }

    public abstract static class EmployeeTypeEnumCreatedEventHandler implements IHandler<EmployeeTypeEnumCreatedEvent> {
        @Override
        public EmployeeTypeEnumCreatedEvent getEvent() {
            return new EmployeeTypeEnumCreatedEvent();
        }
    }
    public void setEmployeeTypeEnumDeactivatedEventHandler(EmployeeTypeEnumDeactivatedEventHandler handler) {
        Event.setTypeHandler(this.config, "contact.employee_type_enum.deactivated_v3", handler);
    }

    public abstract static class EmployeeTypeEnumDeactivatedEventHandler implements IHandler<EmployeeTypeEnumDeactivatedEvent> {
        @Override
        public EmployeeTypeEnumDeactivatedEvent getEvent() {
            return new EmployeeTypeEnumDeactivatedEvent();
        }
    }
    public void setEmployeeTypeEnumDeletedEventHandler(EmployeeTypeEnumDeletedEventHandler handler) {
        Event.setTypeHandler(this.config, "contact.employee_type_enum.deleted_v3", handler);
    }

    public abstract static class EmployeeTypeEnumDeletedEventHandler implements IHandler<EmployeeTypeEnumDeletedEvent> {
        @Override
        public EmployeeTypeEnumDeletedEvent getEvent() {
            return new EmployeeTypeEnumDeletedEvent();
        }
    }
    public void setEmployeeTypeEnumUpdatedEventHandler(EmployeeTypeEnumUpdatedEventHandler handler) {
        Event.setTypeHandler(this.config, "contact.employee_type_enum.updated_v3", handler);
    }

    public abstract static class EmployeeTypeEnumUpdatedEventHandler implements IHandler<EmployeeTypeEnumUpdatedEvent> {
        @Override
        public EmployeeTypeEnumUpdatedEvent getEvent() {
            return new EmployeeTypeEnumUpdatedEvent();
        }
    }

}
