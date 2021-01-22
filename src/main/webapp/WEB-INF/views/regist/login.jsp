<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
  <div class="card">
  <div class="card-header border-0">로그인</div>
    <div class="card-body">
      <form action="${path}/regist/loginPost" method="post">
        <div class="form-group row">
          <input type="text" id="email_address" class="form-control"
          name="email">
        </div>
        <div class="form-group row">
          <input type="password" id="password" class="form-control"
          name="password">
        </div>
				<button type="submit" class="btn btn-primary">로그인</button>			
    </div>
      </form>
  </div>
  <script>
	  var msg = "${msg}";
	  if (msg === "Registered") {
	  	alert("회원가입이 완료되었습니다. 로그인해주세요.")
	  }
  </script>
</body>
</html>