<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

				<form action="/auth/loginProc" method="POST">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">로그인</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="loginUserId" placeholder="Id" name="loginUserId" required autofocus> <label for="floatingInput">ID</label>
						</div>
						<div class="form-floating mb-3">
							<input type="password" class="form-control" id="loginPpassword" placeholder="Password" name="loginPpassword" required> <label for="floatingPassword">Password</label>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>

						<input type="submit" class="btn btn-primary" name="login" value="로그인" > <a href="/auth/joinForm" class="btn btn-secondary">회원가입</a>
					</div>
				</form>
