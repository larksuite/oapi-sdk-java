package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.AppSettings;
import com.larksuite.oapi.core.AppType;
import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Domain;
import com.larksuite.oapi.core.api.request.requestoptfn.UserAccessToken;
import com.larksuite.oapi.core.api.response.Response;
import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.sample.config.Configs;
import com.larksuite.oapi.service.docx.v1.DocxService;
import com.larksuite.oapi.service.docx.v1.model.*;

public class DocxSample {
    // for Cutome APP（自建应用）
    private static final AppSettings appSettings = Config.getInternalAppSettingsByEnv();
    // config with redis store
    // private static final Config config = Configs.getConfigWithRedisStore("https://open.feishu.cn", appSettings);
    // private static final Config config = Configs.getConfig("https://open.feishu.cn", appSettings);
    private static final Config config = Configs.getConfig(Domain.FeiShu, appSettings);

    private static void getDocument(DocxService docxService) throws Exception {
        Response<DocumentGetResult> response = docxService.getDocuments().get().setDocumentId("doxcn0stWG7Zb9ItETHUVHv6fsg").execute();
        System.out.println(response.getRequestID());
        System.out.println(response.getCode());
        System.out.println(response.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }

    private static void getRawDocument(DocxService docxService) throws Exception {
        Response<DocumentRawContentResult> response = docxService.getDocuments().rawContent().setDocumentId("doxcn0stWG7Zb9ItETHUVHv6fsg").execute();
        System.out.println(response.getRequestID());
        System.out.println(response.getCode());
        System.out.println(response.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }

    private static void listBlocks(DocxService docxService) throws Exception {
        Response<DocumentBlockListResult> response = docxService.getDocumentBlocks().list(new UserAccessToken("u-e7a85akZw1njMOmv6BnW0c"))
                .setDocumentId("doxcn0e3YO3OR4kwNQHBcCmGzkc")
                .setPageSize(10)
                .execute();
        System.out.println(response.getRequestID());
        System.out.println(response.getCode());
        System.out.println(response.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }

    private static void getAllSubBlock(DocxService docxService) throws Exception {
        Response<DocumentBlockChildrenGetResult> response = docxService.getDocumentBlockChildrens().get(new UserAccessToken("u-2Pi7c_AzJ0Qr5CPjvkYwrCgg0UZQk1Kxg0w0h5682fIa"))
                .setDocumentId("doxcn0stWG7Zb9ItETHUVHv6fsg")
                .setBlockId("doxcnvDRZwWqR4H2tLvDWi3JHxf")
                .setPageSize(1)
                .execute();
        System.out.println(response.getRequestID());
        System.out.println(response.getCode());
        System.out.println(response.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }

    private static void getBlock(DocxService docxService) throws Exception {
        Response<DocumentBlockGetResult> response = docxService.getDocumentBlocks().get(new UserAccessToken("u-2Pi7c_AzJ0Qr5CPjvkYwrCgg0UZQk1Kxg0w0h5682fIa"))
                .setDocumentId("doxcn0stWG7Zb9ItETHUVHv6fsg")
                .setBlockId("doxcnvDRZwWqR4H2tLvDWi3JHxf")
                .execute();
        System.out.println(response.getRequestID());
        System.out.println(response.getCode());
        System.out.println(response.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }

    private static void createBlock(DocxService docxService) throws Exception {
        DocumentBlockChildrenCreateReqBody req  = new DocumentBlockChildrenCreateReqBody();
        req.setIndex(0);
        Block block = new Block();
        block.setBlockType(2);

        Text text = new Text();
        TextElement e = new TextElement();
        TextRun run = new TextRun();
        run.setContent("插入自夸1");
        TextElementStyle style = new TextElementStyle();
        style.setBackgroundColor(14);
        style.setTextColor(5);
        run.setTextElementStyle(style);
        e.setTextRun(run);
        text.setElements(new TextElement[]{e});
        block.setText(text);

        req.setChildren(new Block[]{block});
        Response<DocumentBlockChildrenCreateResult> response = docxService.getDocumentBlockChildrens().create(req, new UserAccessToken("u-2Pi7c_AzJ0Qr5CPjvkYwrCgg0UZQk1Kxg0w0h5682fIa"))
                .setDocumentId("doxcn0e3YO3OR4kwNQHBcCmGzkc")
                .setBlockId("doxcn0e3YO3OR4kwNQHBcCmGzkc")
                .execute();
        System.out.println(response.getRequestID());
        System.out.println(response.getCode());
        System.out.println(response.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }

    private static void updateBlock(DocxService docxService) throws Exception {
        UpdateBlockRequest req  = new UpdateBlockRequest();
        Block block = new Block();
        block.setBlockType(2);

        Text text = new Text();
        TextElement e = new TextElement();
        TextRun run = new TextRun();
        run.setContent("插入自夸6666");
        TextElementStyle style = new TextElementStyle();
        style.setBackgroundColor(14);
        style.setTextColor(5);
        run.setTextElementStyle(style);
        e.setTextRun(run);
        text.setElements(new TextElement[]{e});
        block.setText(text);


        UpdateTextElementsRequest r = new UpdateTextElementsRequest();
        r.setElements(new TextElement[]{e});
        req.setUpdateTextElements(r);

        Response<DocumentBlockPatchResult> response = docxService.getDocumentBlocks().patch(req, new UserAccessToken("u-2Pi7c_AzJ0Qr5CPjvkYwrCgg0UZQk1Kxg0w0h5682fIa"))
                .setDocumentId("doxcn0e3YO3OR4kwNQHBcCmGzkc")
                .setBlockId("doxcn3KXqJY5TkLejyRus1PQJnh")
                .execute();
        System.out.println(response.getRequestID());
        System.out.println(response.getCode());
        System.out.println(response.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }


    private static void batchUpdateBlock(DocxService docxService) throws Exception {
        UpdateBlockRequest req  = new UpdateBlockRequest();
        Block block = new Block();
        block.setBlockType(2);

        Text text = new Text();
        TextElement e = new TextElement();
        TextRun run = new TextRun();
        run.setContent("插入自夸888");
        TextElementStyle style = new TextElementStyle();
        style.setBackgroundColor(14);
        style.setTextColor(5);
        run.setTextElementStyle(style);
        e.setTextRun(run);
        text.setElements(new TextElement[]{e});
        block.setText(text);


        UpdateTextElementsRequest r = new UpdateTextElementsRequest();
        r.setElements(new TextElement[]{e});
        req.setUpdateTextElements(r);
        req.setBlockId("doxcn3KXqJY5TkLejyRus1PQJnh");

        DocumentBlockBatchUpdateReqBody reqBody = new DocumentBlockBatchUpdateReqBody();
        reqBody.setRequests(new UpdateBlockRequest[]{req});

        Response<DocumentBlockBatchUpdateResult> response = docxService.getDocumentBlocks().batchUpdate(reqBody, new UserAccessToken("u-2Pi7c_AzJ0Qr5CPjvkYwrCgg0UZQk1Kxg0w0h5682fIa"))
                .setDocumentId("doxcn0e3YO3OR4kwNQHBcCmGzkc")
                .execute();
        System.out.println(response.getRequestID());
        System.out.println(response.getCode());
        System.out.println(response.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }




    private static void batchDelBlock(DocxService docxService) throws Exception {

        DocumentBlockChildrenBatchDeleteReqBody req = new DocumentBlockChildrenBatchDeleteReqBody();
        req.setEndIndex(1);
        req.setStartIndex(0);
        Response<DocumentBlockChildrenBatchDeleteResult> response = docxService.getDocumentBlockChildrens().batchDelete(req, new UserAccessToken("u-2Pi7c_AzJ0Qr5CPjvkYwrCgg0UZQk1Kxg0w0h5682fIa"))
                .setDocumentId("doxcn0e3YO3OR4kwNQHBcCmGzkc")
                .setBlockId("doxcn0e3YO3OR4kwNQHBcCmGzkc")
                .execute();
        System.out.println(response.getRequestID());
        System.out.println(response.getCode());
        System.out.println(response.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }


    private static void createDocument(DocxService docxService) throws Exception {

        DocumentCreateReqBody req = new DocumentCreateReqBody();
        req.setFolderToken("fldcniHf40Vcv1DoEc8SXeuA0Zd");
        req.setTitle("document2");
        Response<DocumentCreateResult> response = docxService.getDocuments().create(req,new UserAccessToken("u-2Pi7c_AzJ0Qr5CPjvkYwrCgg0UZQk1Kxg0w0h5682fIa")).execute();
        System.out.println(response.getRequestID());
        System.out.println(response.getCode());
        System.out.println(response.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }


    public static void main(String[] args) throws Exception {
        DocxService docxService = new DocxService(config);
        // getDocument(docxService);
        // getRawDocument(docxService);
          listBlocks(docxService);
        //  getAllSubBlock(docxService);
        //  getBlock(docxService);
       // createDocument(docxService);
       // createBlock(docxService);
      //  updateBlock(docxService);
       // batchUpdateBlock(docxService);
       // batchDelBlock(docxService);
    }
}
