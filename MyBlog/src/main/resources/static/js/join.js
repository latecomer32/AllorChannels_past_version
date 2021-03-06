function joinCheck() {
  /* */

  if (document.join.joinUserId.value == "") {
    alert("아이디 입력하세요");
    document.join.joinUserId.focus();
    return false;
  }

  exp3 = /^[a-z0-9_]+$/;
  if (!exp3.test(document.join.joinUserId.value)) {
    alert("아이디를 영문과 숫자로만 입력하세요");
    document.join.joinUserId.focus();
    return false;
  }

  if (document.join.joinPassword.value == "") {
    alert("비밀번호를 입력하세요");
    document.join.joinPassword.focus();
    document.join.joinPassword.value = "";
    return false;
  }

  if (document.join.joinPassword.value.length < 4) {
    alert("비밀번호를 4자리 이상 입력하세요");
    document.join.joinPassword.focus();
    document.join.joinPassword.value = "";
    return false;
  }

  exp2 = /^[a-z0-9_]+$/;
  if (!exp2.test(document.join.joinPassword.value)) {
    alert("비밀번호를 영문과 숫자로만 입력하세요");
    document.join.joinPassword.focus();
    document.join.joinPassword.value = "";
    return false;
  }

  if (document.join.PasswordCheck.value == "") {
    alert("비밀번호를 다시 입력하세요");
    document.join.PasswordCheck.focus();
    document.join.PasswordCheck.value = "";
    return false;
  }

  if (document.join.joinPassword.value != document.join.PasswordCheck.value) {
    alert("비밀번호가 일치하지 않습니다.");
    document.join.joinPassword.focus();
    document.join.PasswordCheck.value = "";
    document.join.joinPassword.value = "";
    return false;
  }

  if (document.join.joinNickName.value == "") {
    alert("닉네임을 입력해주세요");
    document.join.joinNickName.focus();
    return false;
  }

  exp4 = /^[가-힣a-zA-Z0-9_]+$/;
  if (!exp4.test(document.join.joinNickName.value)) {
    alert("닉네임을 한글,영어,숫자로 입력해주세요");
    document.join.joinNickName.focus();
    return false;
  }
}
