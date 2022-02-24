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
      alert("채널 개설 완료.");
      location.href = "/index";
    })
    .fail(function (error) {
      alert(JSON.stringify(error));
    });
}

function deleteChannel() {
  (deleteChannelName = $("#deleteChannelName").val()),
    console.log(deleteChannelName);
  $.ajax({
    type: "POST",
    url: "/left/delete/channel",
    data: deleteChannelName,
    contentType: "application/json; charset=utf-8",
    dataType: "text",
  })
    .done(function (resp) {
      alert("채널 삭제 완료");
      location.href = "/index";
    })
    .fail(function (error) {
      alert(JSON.stringify(error));
    });
}
