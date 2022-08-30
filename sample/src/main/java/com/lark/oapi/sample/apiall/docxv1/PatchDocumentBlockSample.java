package com.lark.oapi.sample.apiall.docxv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.docx.v1.model.DeleteGridColumnRequest;
import com.lark.oapi.service.docx.v1.model.DeleteTableColumnsRequest;
import com.lark.oapi.service.docx.v1.model.DeleteTableRowsRequest;
import com.lark.oapi.service.docx.v1.model.InsertGridColumnRequest;
import com.lark.oapi.service.docx.v1.model.InsertTableColumnRequest;
import com.lark.oapi.service.docx.v1.model.InsertTableRowRequest;
import com.lark.oapi.service.docx.v1.model.MergeTableCellsRequest;
import com.lark.oapi.service.docx.v1.model.PatchDocumentBlockReq;
import com.lark.oapi.service.docx.v1.model.PatchDocumentBlockResp;
import com.lark.oapi.service.docx.v1.model.ReplaceFileRequest;
import com.lark.oapi.service.docx.v1.model.ReplaceImageRequest;
import com.lark.oapi.service.docx.v1.model.UnmergeTableCellsRequest;
import com.lark.oapi.service.docx.v1.model.UpdateBlockRequest;
import com.lark.oapi.service.docx.v1.model.UpdateGridColumnWidthRatioRequest;
import com.lark.oapi.service.docx.v1.model.UpdateTablePropertyRequest;
import com.lark.oapi.service.docx.v1.model.UpdateTextElementsRequest;
import com.lark.oapi.service.docx.v1.model.UpdateTextRequest;
import com.lark.oapi.service.docx.v1.model.UpdateTextStyleRequest;

// PATCH /open-apis/docx/v1/documents/:document_id/blocks/:block_id
public class PatchDocumentBlockSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    PatchDocumentBlockReq req = PatchDocumentBlockReq.newBuilder()
        .documentId("doxcnePuYufKa49ISjhD8Ih0ikh")
        .blockId("doxcnO6UW6wAw2qIcYf4hZpFIth")
        .documentRevisionId(-1)
        .clientToken("0e2633a3-aa1a-4171-af9e-0768ff863566")
        .userIdType("user_id")
        .updateBlockRequest(UpdateBlockRequest.newBuilder()
            .updateTextElements(UpdateTextElementsRequest.newBuilder().build())
            .updateTextStyle(UpdateTextStyleRequest.newBuilder().build())
            .updateTableProperty(UpdateTablePropertyRequest.newBuilder().build())
            .insertTableRow(InsertTableRowRequest.newBuilder().build())
            .insertTableColumn(InsertTableColumnRequest.newBuilder().build())
            .deleteTableRows(DeleteTableRowsRequest.newBuilder().build())
            .deleteTableColumns(DeleteTableColumnsRequest.newBuilder().build())
            .mergeTableCells(MergeTableCellsRequest.newBuilder().build())
            .unmergeTableCells(UnmergeTableCellsRequest.newBuilder().build())
            .insertGridColumn(InsertGridColumnRequest.newBuilder().build())
            .deleteGridColumn(DeleteGridColumnRequest.newBuilder().build())
            .updateGridColumnWidthRatio(UpdateGridColumnWidthRatioRequest.newBuilder().build())
            .replaceImage(ReplaceImageRequest.newBuilder().build())
            .replaceFile(ReplaceFileRequest.newBuilder().build())
            .updateText(UpdateTextRequest.newBuilder().build())
            .build())
        .build();

    // 发起请求
    PatchDocumentBlockResp resp = client.docx().documentBlock().patch(req);

    // 处理服务端错误
    if (!resp.success()) {
      System.out.println(String.format("code:%s,msg:%s,reqId:%s"
          , resp.getCode(), resp.getMsg(), resp.getRequestId()));
      return;
    }

    // 业务数据处理
    System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
  }
}
