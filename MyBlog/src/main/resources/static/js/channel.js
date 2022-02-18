function btn_saveChannel() {
  (channelName = $("#channelName").val()), console.log(channelName);
  $.ajax({
    type: "POST",
    url: "/header/save/channel",
    data: channelName,
    contentType: "application/json; charset=utf-8",
    dataType: "text",
  })
    .done(function (resp) {
      alert("데이터 전송완료");
      location.href = "/index";
    })
    .fail(function (error) {
      alert(JSON.stringify(error));
    });
}
