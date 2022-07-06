// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.translation.v1;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Transport;
import com.larksuite.oapi.core.request.RequestOptions;
import com.larksuite.oapi.core.response.RawResponse;
import com.larksuite.oapi.core.token.AccessTokenType;
import com.larksuite.oapi.core.utils.Sets;
import com.larksuite.oapi.core.utils.UnmarshalRespUtil;
import com.larksuite.oapi.service.translation.v1.model.DetectTextReq;
import com.larksuite.oapi.service.translation.v1.model.DetectTextResp;
import com.larksuite.oapi.service.translation.v1.model.TranslateTextReq;
import com.larksuite.oapi.service.translation.v1.model.TranslateTextResp;

public class TranslationService {
    private final Text text;

    public TranslationService(Config config) {
        this.text = new Text(config);
    }

    public Text text() {
        return text;
    }

    public static class Text {
        private final Config config;

        public Text(Config config) {
            this.config = config;
        }

        public DetectTextResp detect(DetectTextReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/translation/v1/text/detect"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            DetectTextResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, DetectTextResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public DetectTextResp detect(DetectTextReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/translation/v1/text/detect"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            DetectTextResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, DetectTextResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public TranslateTextResp translate(TranslateTextReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/translation/v1/text/translate"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            TranslateTextResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, TranslateTextResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public TranslateTextResp translate(TranslateTextReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/translation/v1/text/translate"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            TranslateTextResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, TranslateTextResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }
    }

}