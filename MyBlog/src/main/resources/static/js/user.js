let user = {
  init: function () {
    $("#btn-save").on("click", () => {
      //()=>{} this를 바인딩하기 위해서!
      this.save();
    });
    $("#btn-update").on("click", () => {
      //()=>{} this를 바인딩하기 위해서!
      this.update();
    });
    // $("#btn-login").on("click", () => {
    //   //()=>{} this를 바인딩하기 위해서!
    //   this.login();
    // });
  },

  save: function () {
    //alert("user의 save함수 호출됨");
    let data = {
      //id값으로 찾아서 값 가져옴
      userId: $("#joinUserId").val(),
      nickName: $("#joinNickName").val(),
      password: $("#joinPassword").val(),
      email: $("#email").val(),
    };

    //console.log(data);

    // ajax호출시 default가 비동기 호출
    // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청!
    // ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환해주네요.
    $.ajax({
      //회원가입 수행 요청
      type: "POST",
      url: "/auth/joinForm",
      data: JSON.stringify(data), //http body 데이터, JavaScript 값이나 객체를 JSON 문자열로 변환해준다
      contentType: "application/json; charset=utf-8", //body데이터가 어떤 타입인지(MIME)
      dataType: "json", // 요청을 서버로 해서 응답이 왔을 때 기본적으로 모든 것이 문자열(생긴게 json이라면)=> javascript 오브젝트로 변경
    })
      .done(function (resp) {
        alert("회원가입이 완료되었습니다.");

        location.href = "/index";
      })
      .fail(function (error) {
        console.log("실패 data:", data); //console.log("실패 data:"+ data); 라고 쓰면 원하는대로 출력되지 않았었음.
        alert(JSON.stringify(error.responseText));
      }); //ajax 통신을 이용해서 3개의 데이터를 json으로 변경히여 insert 요청!!
  },

  update: function () {
    let data = {
      id: $("#id").val(),
      username: $("#password").val(),
      password: $("#password").val(),
      email: $("#email").val(),
    };
    $.ajax({
      type: "PUT",
      url: "/user",
      data: JSON.stringify(data),
      contentType: "application/json; charset=utf-8",
      dataType: "json",
    })
      .done(function (resp) {
        alert("회원수정이 완료되었습니다.");
        location.href = "/index";
      })
      .fail(function (error) {
        alert(JSON.stringify(error));
      });
  },

  // login: function () {
  //   //alert("user의 save함수 호출됨");
  //   let data = {
  //     //id값으로 찾아서 값 가져옴
  //     username: $("#username").val(),
  //     password: $("#password").val(),
  //     email: $("#email").val(),
  //   };

  //   //console.log(data);

  //   // ajax호출시 default가 비동기 호출
  //   // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청!
  //   // ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환해주네요.
  //   $.ajax({
  //     //회원가입 수행 요청
  //     type: "POST",
  //     url: "/api/user/login",
  //     data: JSON.stringify(data),
  //     contentType: "application/json; charset=utf-8", //body데이터가 어떤 타입인지(MIME)
  //     dataType: "json", // 요청을 서버로 해서 응답이 왔을 때 기본적으로 모든 것이 문자열(생긴게 json이라면)=> javascript 오브젝트로 변경
  //   })
  //     .done(function (resp) {
  //       alert("로그인이 완료되었습니다.");

  //       location.href = "/";
  //     })
  //     .fail(function (error) {
  //       alert(JSON.stringify(error));
  //     }); //ajax 통신을 이용해서 3개의 데이터를 json으로 변경히여 insert 요청!!
  // },
};

user.init();
