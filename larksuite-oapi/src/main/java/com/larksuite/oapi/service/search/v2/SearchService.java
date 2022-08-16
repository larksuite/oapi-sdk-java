// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.search.v2;

import com.larksuite.oapi.core.api.AccessTokenType;
import com.larksuite.oapi.core.api.Api;
import com.larksuite.oapi.core.api.ReqCaller;
import com.larksuite.oapi.core.api.request.*;
import com.larksuite.oapi.core.api.response.*;
import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.service.search.v2.model.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class SearchService {

    private final Config config;
    private final DataSources dataSources;
    private final DataSourceItems dataSourceItems;

    public SearchService(Config config) {
        this.config = config;
        this.dataSources = new DataSources(this);
        this.dataSourceItems = new DataSourceItems(this);
    }

    public DataSources getDataSources() {
        return dataSources;
    }

    public static class DataSources {

        private final SearchService service;

        public DataSources(SearchService service) {
            this.service = service;
        }
    
        public DataSourceCreateReqCall create(DataSource body, RequestOptFn... optFns) {
            return new DataSourceCreateReqCall(this, body, optFns);
        }
    
        public DataSourceDeleteReqCall delete(RequestOptFn... optFns) {
            return new DataSourceDeleteReqCall(this, optFns);
        }
    
        public DataSourceGetReqCall get(RequestOptFn... optFns) {
            return new DataSourceGetReqCall(this, optFns);
        }
    
        public DataSourceListReqCall list(RequestOptFn... optFns) {
            return new DataSourceListReqCall(this, optFns);
        }
    
        public DataSourcePatchReqCall patch(DataSourcePatchReqBody body, RequestOptFn... optFns) {
            return new DataSourcePatchReqCall(this, body, optFns);
        }
    
    }
    public static class DataSourceCreateReqCall extends ReqCaller<DataSource, DataSourceCreateResult> {
        private final DataSources dataSources;
        
        private final DataSource body;
        private final List<RequestOptFn> optFns;
        private DataSourceCreateResult result;
        
        private DataSourceCreateReqCall(DataSources dataSources, DataSource body, RequestOptFn... optFns) {
        
            this.body = body;
            this.optFns = new ArrayList<>();
            this.optFns.addAll(Arrays.asList(optFns));
            this.result = new DataSourceCreateResult();
            this.dataSources = dataSources;
        }
        

        @Override
        public Response<DataSourceCreateResult> execute() throws Exception {
            com.larksuite.oapi.core.api.request.Request<DataSource, DataSourceCreateResult> request = com.larksuite.oapi.core.api.request.Request.newRequest("/open-apis/search/v2/data_sources", "POST",
                    new AccessTokenType[]{AccessTokenType.Tenant},
                    this.body, this.result, this.optFns.toArray(new RequestOptFn[]{}));
            return Api.send(this.dataSources.service.config, request);
        }
    }
    public static class DataSourceDeleteReqCall extends ReqCaller<Object, EmptyData> {
        private final DataSources dataSources;
        
        private final Map<String, Object> pathParams;
        private final List<RequestOptFn> optFns;
        private EmptyData result;
        
        private DataSourceDeleteReqCall(DataSources dataSources, RequestOptFn... optFns) {
        
            this.pathParams = new HashMap<>();
            this.optFns = new ArrayList<>();
            this.optFns.addAll(Arrays.asList(optFns));
            this.result = new EmptyData();
            this.dataSources = dataSources;
        }
        
        public DataSourceDeleteReqCall setDataSourceId(String dataSourceId){
            this.pathParams.put("data_source_id", dataSourceId);
            return this;
        }

        @Override
        public Response<EmptyData> execute() throws Exception {
            this.optFns.add(com.larksuite.oapi.core.api.request.Request.setPathParams(this.pathParams));
            com.larksuite.oapi.core.api.request.Request<Object, EmptyData> request = com.larksuite.oapi.core.api.request.Request.newRequest("/open-apis/search/v2/data_sources/:data_source_id", "DELETE",
                    new AccessTokenType[]{AccessTokenType.Tenant},
                    null, this.result, this.optFns.toArray(new RequestOptFn[]{}));
            return Api.send(this.dataSources.service.config, request);
        }
    }
    public static class DataSourceGetReqCall extends ReqCaller<Object, DataSourceGetResult> {
        private final DataSources dataSources;
        
        private final Map<String, Object> pathParams;
        private final List<RequestOptFn> optFns;
        private DataSourceGetResult result;
        
        private DataSourceGetReqCall(DataSources dataSources, RequestOptFn... optFns) {
        
            this.pathParams = new HashMap<>();
            this.optFns = new ArrayList<>();
            this.optFns.addAll(Arrays.asList(optFns));
            this.result = new DataSourceGetResult();
            this.dataSources = dataSources;
        }
        
        public DataSourceGetReqCall setDataSourceId(String dataSourceId){
            this.pathParams.put("data_source_id", dataSourceId);
            return this;
        }

        @Override
        public Response<DataSourceGetResult> execute() throws Exception {
            this.optFns.add(com.larksuite.oapi.core.api.request.Request.setPathParams(this.pathParams));
            com.larksuite.oapi.core.api.request.Request<Object, DataSourceGetResult> request = com.larksuite.oapi.core.api.request.Request.newRequest("/open-apis/search/v2/data_sources/:data_source_id", "GET",
                    new AccessTokenType[]{AccessTokenType.Tenant},
                    null, this.result, this.optFns.toArray(new RequestOptFn[]{}));
            return Api.send(this.dataSources.service.config, request);
        }
    }
    public static class DataSourceListReqCall extends ReqCaller<Object, DataSourceListResult> {
        private final DataSources dataSources;
        
        private final Map<String, Object> queryParams;
        private final List<RequestOptFn> optFns;
        private DataSourceListResult result;
        
        private DataSourceListReqCall(DataSources dataSources, RequestOptFn... optFns) {
        
            this.queryParams = new HashMap<>();
            this.optFns = new ArrayList<>();
            this.optFns.addAll(Arrays.asList(optFns));
            this.result = new DataSourceListResult();
            this.dataSources = dataSources;
        }
        
        
        public DataSourceListReqCall setView(Integer view){
            this.queryParams.put("view", view);
            return this;
        }
        public DataSourceListReqCall setPageToken(String pageToken){
            this.queryParams.put("page_token", pageToken);
            return this;
        }
        public DataSourceListReqCall setPageSize(Integer pageSize){
            this.queryParams.put("page_size", pageSize);
            return this;
        }

        @Override
        public Response<DataSourceListResult> execute() throws Exception {
            this.optFns.add(com.larksuite.oapi.core.api.request.Request.setQueryParams(this.queryParams));
            com.larksuite.oapi.core.api.request.Request<Object, DataSourceListResult> request = com.larksuite.oapi.core.api.request.Request.newRequest("/open-apis/search/v2/data_sources", "GET",
                    new AccessTokenType[]{AccessTokenType.Tenant},
                    null, this.result, this.optFns.toArray(new RequestOptFn[]{}));
            return Api.send(this.dataSources.service.config, request);
        }
    }
    public static class DataSourcePatchReqCall extends ReqCaller<DataSourcePatchReqBody, DataSourcePatchResult> {
        private final DataSources dataSources;
        
        private final DataSourcePatchReqBody body;
        private final Map<String, Object> pathParams;
        private final List<RequestOptFn> optFns;
        private DataSourcePatchResult result;
        
        private DataSourcePatchReqCall(DataSources dataSources, DataSourcePatchReqBody body, RequestOptFn... optFns) {
        
            this.body = body;
            this.pathParams = new HashMap<>();
            this.optFns = new ArrayList<>();
            this.optFns.addAll(Arrays.asList(optFns));
            this.result = new DataSourcePatchResult();
            this.dataSources = dataSources;
        }
        
        public DataSourcePatchReqCall setDataSourceId(String dataSourceId){
            this.pathParams.put("data_source_id", dataSourceId);
            return this;
        }

        @Override
        public Response<DataSourcePatchResult> execute() throws Exception {
            this.optFns.add(com.larksuite.oapi.core.api.request.Request.setPathParams(this.pathParams));
            com.larksuite.oapi.core.api.request.Request<DataSourcePatchReqBody, DataSourcePatchResult> request = com.larksuite.oapi.core.api.request.Request.newRequest("/open-apis/search/v2/data_sources/:data_source_id", "PATCH",
                    new AccessTokenType[]{AccessTokenType.Tenant},
                    this.body, this.result, this.optFns.toArray(new RequestOptFn[]{}));
            return Api.send(this.dataSources.service.config, request);
        }
    }

    public DataSourceItems getDataSourceItems() {
        return dataSourceItems;
    }

    public static class DataSourceItems {

        private final SearchService service;

        public DataSourceItems(SearchService service) {
            this.service = service;
        }
    
        public DataSourceItemCreateReqCall create(Item body, RequestOptFn... optFns) {
            return new DataSourceItemCreateReqCall(this, body, optFns);
        }
    
        public DataSourceItemDeleteReqCall delete(RequestOptFn... optFns) {
            return new DataSourceItemDeleteReqCall(this, optFns);
        }
    
        public DataSourceItemGetReqCall get(RequestOptFn... optFns) {
            return new DataSourceItemGetReqCall(this, optFns);
        }
    
    }
    public static class DataSourceItemCreateReqCall extends ReqCaller<Item, EmptyData> {
        private final DataSourceItems dataSourceItems;
        
        private final Item body;
        private final Map<String, Object> pathParams;
        private final List<RequestOptFn> optFns;
        private EmptyData result;
        
        private DataSourceItemCreateReqCall(DataSourceItems dataSourceItems, Item body, RequestOptFn... optFns) {
        
            this.body = body;
            this.pathParams = new HashMap<>();
            this.optFns = new ArrayList<>();
            this.optFns.addAll(Arrays.asList(optFns));
            this.result = new EmptyData();
            this.dataSourceItems = dataSourceItems;
        }
        
        public DataSourceItemCreateReqCall setDataSourceId(String dataSourceId){
            this.pathParams.put("data_source_id", dataSourceId);
            return this;
        }

        @Override
        public Response<EmptyData> execute() throws Exception {
            this.optFns.add(com.larksuite.oapi.core.api.request.Request.setPathParams(this.pathParams));
            com.larksuite.oapi.core.api.request.Request<Item, EmptyData> request = com.larksuite.oapi.core.api.request.Request.newRequest("/open-apis/search/v2/data_sources/:data_source_id/items", "POST",
                    new AccessTokenType[]{AccessTokenType.Tenant},
                    this.body, this.result, this.optFns.toArray(new RequestOptFn[]{}));
            return Api.send(this.dataSourceItems.service.config, request);
        }
    }
    public static class DataSourceItemDeleteReqCall extends ReqCaller<Object, EmptyData> {
        private final DataSourceItems dataSourceItems;
        
        private final Map<String, Object> pathParams;
        private final List<RequestOptFn> optFns;
        private EmptyData result;
        
        private DataSourceItemDeleteReqCall(DataSourceItems dataSourceItems, RequestOptFn... optFns) {
        
            this.pathParams = new HashMap<>();
            this.optFns = new ArrayList<>();
            this.optFns.addAll(Arrays.asList(optFns));
            this.result = new EmptyData();
            this.dataSourceItems = dataSourceItems;
        }
        
        public DataSourceItemDeleteReqCall setDataSourceId(String dataSourceId){
            this.pathParams.put("data_source_id", dataSourceId);
            return this;
        }
        public DataSourceItemDeleteReqCall setItemId(String itemId){
            this.pathParams.put("item_id", itemId);
            return this;
        }

        @Override
        public Response<EmptyData> execute() throws Exception {
            this.optFns.add(com.larksuite.oapi.core.api.request.Request.setPathParams(this.pathParams));
            com.larksuite.oapi.core.api.request.Request<Object, EmptyData> request = com.larksuite.oapi.core.api.request.Request.newRequest("/open-apis/search/v2/data_sources/:data_source_id/items/:item_id", "DELETE",
                    new AccessTokenType[]{AccessTokenType.Tenant},
                    null, this.result, this.optFns.toArray(new RequestOptFn[]{}));
            return Api.send(this.dataSourceItems.service.config, request);
        }
    }
    public static class DataSourceItemGetReqCall extends ReqCaller<Object, DataSourceItemGetResult> {
        private final DataSourceItems dataSourceItems;
        
        private final Map<String, Object> pathParams;
        private final List<RequestOptFn> optFns;
        private DataSourceItemGetResult result;
        
        private DataSourceItemGetReqCall(DataSourceItems dataSourceItems, RequestOptFn... optFns) {
        
            this.pathParams = new HashMap<>();
            this.optFns = new ArrayList<>();
            this.optFns.addAll(Arrays.asList(optFns));
            this.result = new DataSourceItemGetResult();
            this.dataSourceItems = dataSourceItems;
        }
        
        public DataSourceItemGetReqCall setDataSourceId(String dataSourceId){
            this.pathParams.put("data_source_id", dataSourceId);
            return this;
        }
        public DataSourceItemGetReqCall setItemId(String itemId){
            this.pathParams.put("item_id", itemId);
            return this;
        }

        @Override
        public Response<DataSourceItemGetResult> execute() throws Exception {
            this.optFns.add(com.larksuite.oapi.core.api.request.Request.setPathParams(this.pathParams));
            com.larksuite.oapi.core.api.request.Request<Object, DataSourceItemGetResult> request = com.larksuite.oapi.core.api.request.Request.newRequest("/open-apis/search/v2/data_sources/:data_source_id/items/:item_id", "GET",
                    new AccessTokenType[]{AccessTokenType.Tenant},
                    null, this.result, this.optFns.toArray(new RequestOptFn[]{}));
            return Api.send(this.dataSourceItems.service.config, request);
        }
    }

}