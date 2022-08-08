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

package com.lark.oapi.service.ext;

import com.lark.oapi.core.Config;
import com.lark.oapi.core.Constants;
import com.lark.oapi.core.Transport;
import com.lark.oapi.core.request.MarketplaceAppAccessTokenReq;
import com.lark.oapi.core.request.MarketplaceTenantAccessTokenReq;
import com.lark.oapi.core.request.RequestOptions;
import com.lark.oapi.core.request.SelfBuiltAppAccessTokenReq;
import com.lark.oapi.core.request.SelfBuiltTenantAccessTokenReq;
import com.lark.oapi.core.response.AppAccessTokenResp;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.response.TenantAccessTokenResp;
import com.lark.oapi.core.token.AccessTokenType;
import com.lark.oapi.core.utils.Sets;
import com.lark.oapi.core.utils.UnmarshalRespUtil;
import com.lark.oapi.service.ext.model.AuthenAccessTokenReq;
import com.lark.oapi.service.ext.model.AuthenAccessTokenResp;
import com.lark.oapi.service.ext.model.CreateFileReq;
import com.lark.oapi.service.ext.model.CreateFileResp;
import com.lark.oapi.service.ext.model.GetAuthenUserInfoResp;
import com.lark.oapi.service.ext.model.RefreshAuthenAccessTokenReq;
import com.lark.oapi.service.ext.model.RefreshAuthenAccessTokenResp;

public class ExtService {

  private Config config;

  public ExtService(Config config) {
    this.config = config;
  }

  /*
  在用户云空间指定文件夹中创建文档、电子表格或者多维表格。
  如果目标文件夹是我的空间，则新建的文档会在「我的空间」的「归我所有」列表里。
  link: https://open.feishu.cn/document/ukTMukTMukTM/uQTNzUjL0UzM14CN1MTN
 */
  public CreateFileResp createFile(CreateFileReq req, RequestOptions requestOptions)
      throws Exception {
    RawResponse resp = Transport.send(config
        , requestOptions, "POST"
        , "/open-apis/drive/explorer/v2/file/:folderToken"
        , Sets.newHashSet(AccessTokenType.Tenant, AccessTokenType.User), req);

    CreateFileResp createFileResp = UnmarshalRespUtil.unmarshalResp(resp,
        CreateFileResp.class);
    createFileResp.setRawResponse(resp);
    return createFileResp;
  }

  /*
  在用户云空间指定文件夹中创建文档、电子表格或者多维表格。
  如果目标文件夹是我的空间，则新建的文档会在「我的空间」的「归我所有」列表里。
  link: https://open.feishu.cn/document/ukTMukTMukTM/uQTNzUjL0UzM14CN1MTN
   */
  public CreateFileResp createFile(CreateFileReq req) throws Exception {
    return createFile(req, null);
  }

  public AppAccessTokenResp getAppAccessTokenBySelfBuiltApp(SelfBuiltAppAccessTokenReq req)
      throws Exception {
    RawResponse resp = Transport.send(config
        , new RequestOptions(), "POST"
        , Constants.APP_ACCESS_TOKEN_INTERNAL_URL_PATH
        , Sets.newHashSet(AccessTokenType.None), req);

    AppAccessTokenResp appAccessTokenResp = UnmarshalRespUtil.unmarshalResp(resp,
        AppAccessTokenResp.class);
    appAccessTokenResp.setRawResponse(resp);
    return appAccessTokenResp;
  }

  public AppAccessTokenResp getAppAccessTokenByMarketplaceApp(MarketplaceAppAccessTokenReq req)
      throws Exception {
    RawResponse resp = Transport.send(config
        , new RequestOptions(), "POST"
        , Constants.APP_ACCESS_TOKEN_ISV_URL_PATH
        , Sets.newHashSet(AccessTokenType.None), req);

    // 结果处理
    AppAccessTokenResp appAccessTokenResp = UnmarshalRespUtil.unmarshalResp(resp,
        AppAccessTokenResp.class);
    appAccessTokenResp.setRawResponse(resp);
    return appAccessTokenResp;
  }

  public TenantAccessTokenResp getTenantAccessTokenBySelfBuiltApp(SelfBuiltTenantAccessTokenReq req)
      throws Exception {
    RawResponse resp = Transport.send(config
        , new RequestOptions(), "POST"
        , Constants.TENANT_ACCESS_TOKEN_INTERNAL_URL_PATH
        , Sets.newHashSet(AccessTokenType.None), req);

    TenantAccessTokenResp tenantAccessTokenResp = UnmarshalRespUtil.unmarshalResp(resp,
        TenantAccessTokenResp.class);
    tenantAccessTokenResp.setRawResponse(resp);
    return tenantAccessTokenResp;
  }

  public TenantAccessTokenResp getTenantAccessTokenByMarketplaceApp(
      MarketplaceTenantAccessTokenReq req)
      throws Exception {

    RawResponse resp = Transport.send(config
        , new RequestOptions(), "POST"
        , Constants.TENANT_ACCESS_TOKEN_ISV_URL_PATH
        , Sets.newHashSet(AccessTokenType.None), req);

    TenantAccessTokenResp tenantAccessTokenResp = UnmarshalRespUtil.unmarshalResp(resp,
        TenantAccessTokenResp.class);
    tenantAccessTokenResp.setRawResponse(resp);
    return tenantAccessTokenResp;
  }

  public AuthenAccessTokenResp getAuthenAccessToken(
      AuthenAccessTokenReq req)
      throws Exception {

    RawResponse resp = Transport.send(config
        , new RequestOptions(), "POST"
        , Constants.GET_AUTHEN_ACCESS_TOKEN
        , Sets.newHashSet(AccessTokenType.App), req);

    AuthenAccessTokenResp authenAccessTokenResp = UnmarshalRespUtil.unmarshalResp(resp,
        AuthenAccessTokenResp.class);
    authenAccessTokenResp.setRawResponse(resp);
    return authenAccessTokenResp;
  }

  public AuthenAccessTokenResp getAuthenAccessToken(
      AuthenAccessTokenReq req, RequestOptions requestOptions)
      throws Exception {

    RawResponse resp = Transport.send(config
        , requestOptions
        , "POST"
        , Constants.GET_AUTHEN_ACCESS_TOKEN
        , Sets.newHashSet(AccessTokenType.App), req);

    AuthenAccessTokenResp authenAccessTokenResp = UnmarshalRespUtil.unmarshalResp(resp,
        AuthenAccessTokenResp.class);
    authenAccessTokenResp.setRawResponse(resp);
    return authenAccessTokenResp;
  }

  public RefreshAuthenAccessTokenResp refreshAuthenAccessToken(
      RefreshAuthenAccessTokenReq req, RequestOptions requestOptions)
      throws Exception {

    RawResponse resp = Transport.send(config
        , requestOptions
        , "POST"
        , Constants.REFRESH_AUTHEN_ACCESS_TOKEN
        , Sets.newHashSet(AccessTokenType.App), req);

    RefreshAuthenAccessTokenResp authenAccessTokenResp = UnmarshalRespUtil.unmarshalResp(resp,
        RefreshAuthenAccessTokenResp.class);
    authenAccessTokenResp.setRawResponse(resp);
    return authenAccessTokenResp;
  }

  public RefreshAuthenAccessTokenResp refreshAuthenAccessToken(
      RefreshAuthenAccessTokenReq req)
      throws Exception {

    RawResponse resp = Transport.send(config
        , new RequestOptions()
        , "POST"
        , Constants.REFRESH_AUTHEN_ACCESS_TOKEN
        , Sets.newHashSet(AccessTokenType.App), req);

    RefreshAuthenAccessTokenResp authenAccessTokenResp = UnmarshalRespUtil.unmarshalResp(resp,
        RefreshAuthenAccessTokenResp.class);
    authenAccessTokenResp.setRawResponse(resp);
    return authenAccessTokenResp;
  }

  public GetAuthenUserInfoResp getAuthenUserInfo(RequestOptions requestOptions)
      throws Exception {

    RawResponse resp = Transport.send(config
        , requestOptions
        , "GET"
        , Constants.GET_AUTHEN_USER_INFO
        , Sets.newHashSet(AccessTokenType.User), null);

    GetAuthenUserInfoResp authenAccessTokenResp = UnmarshalRespUtil.unmarshalResp(resp,
        GetAuthenUserInfoResp.class);
    authenAccessTokenResp.setRawResponse(resp);
    return authenAccessTokenResp;
  }


}
