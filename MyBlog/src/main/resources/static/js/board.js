let index = {
  init: function () {
    $("#btn-saveTheWriting").on("click", () => {
      this.saveTheWriting();
    });
    $("#btn-delete").on("click", () => {
      this.deleteById();
    });
    $("#btn-update").on("click", () => {
      this.update();
    });
    $("#btn-reply-save").on("click", () => {
      this.replySave();
    });
    $("#btn-writing-filter").on("click", () => {
      this.writingFilter();
    });
  },

  saveTheWriting: function () {
    let data = {
      title: $("#title").val(),
      content: $("#summernote").val(),
      categoryName: $("#categoryName").val(),
    };
    $.ajax({
      type: "POST",
      url: "/board/saveTheWritingForm",
      data: JSON.stringify(data),
      contentType: "application/json; charset=utf-8",
      dataType: "json",
    })
      .done(function (resp) {
        alert("글쓰기가 완료되었습니다.");
        location.href = "/";
      })
      .fail(function (error) {
        alert(JSON.stringify(error));
      });
  },

  deleteById: function () {
    //let id = $("#id").val(); 아래 data부분 없애고 이렇게만 넣으면 - (1/3)

    let no = "";

    $("input[name=no]:checked").each(function () {
      var no = $(this).attr("value");
      console.log(no);

      $.ajax({
        type: "DELETE",
        url: "/board/detail/" + no,
        data: JSON.stringify(no),
      })
        .done(function (resp) {
          alert("글삭제가 완료되었습니다.");
          location.href = "/";
        })
        .fail(function (error) {
          alert(JSON.stringify(error));
        });
    });
  },

  update: function () {
    let id = $("#id").val();
    let data = {
      title: $("#title").val(),
      content: $("#content").val(),
    };
    $.ajax({
      type: "PUT",
      url: "/api/board/" + id,
      data: JSON.stringify(data),
      contentType: "application/json; charset=utf-8",
      dataType: "json",
    })
      .done(function (resp) {
        alert("글수정이 완료되었습니다.");
        location.href = "/";
      })
      .fail(function (error) {
        alert(JSON.stringify(error));
      });
  },

  replySave: function () {
    let data = {
      content: $("#reply-content").val(),
    };
    let boardId = $("#boardId").val();

    $.ajax({
      type: "POST",
      url: `/api/board/${boardId}/reply`,
      data: JSON.stringify(data),
      contentType: "application/json; charset=utf-8",
      dataType: "json",
    })
      .done(function (resp) {
        alert("댓글작성이 완료되었습니다.");
        location.href = `/board/${boardId}`;
      })
      .fail(function (error) {
        alert(JSON.stringify(error));
      });
  },
  writingFilter: function () {
    let data = {
      page: $("#p").val(),
      field: $("#f").val(),
      query: $("#q").val(),
      pub: $("#reply-content").val(),
      rowNum: $("#r").val(),
      desc: $("#desc").val(),
      order: $("#order").val(),
    };

    $.ajax({
      type: "GET",
      url: `/`,
      data: JSON.stringify(data),
      contentType: "application/json; charset=utf-8",
      dataType: "json",
    })
      .done(function (resp) {
        alert("데이터 전송완료");
        location.href = `/board/${boardId}`;
      })
      .fail(function (error) {
        alert(JSON.stringify(error));
      });
  },
};

index.init();
