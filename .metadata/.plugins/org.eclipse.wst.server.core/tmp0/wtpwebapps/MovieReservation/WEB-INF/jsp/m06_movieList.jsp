<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>映画一覧</title>
</head>
<body>
  <p>キーワード検索欄に映画名を入力すると該当する映画を表示します</p>
  
  <article>
    <form>
      <p>キーワード検索</p><br>
      <input type="text" name="keyword" value="">
      <input type="submit" value="検索"><br>
      <p>絞り込み</p><br>
      <p>
        <input type="checkbox" name="Release" value="1">公開前
        <input type="checkbox" name="Release" value="2">公開中
        <input type="checkbox" name="Release" value="3">公開終了
      <p>
    </form>
  </article>
  
  <article>
    <table>
      <tr>
        <th>映画名</th><th>公開状況</th><th>更新</th><th>削除</th>
      </tr>
      <tr>
        <td><%= %></td><td><%= %></td><td><a href="">更新</a></td><td><a href="m10_movieDelete">削除</a></td>
      </tr>
    </table>
  </article>
  
  <?php $count1 = count?><%= %><?; print('/'.$count1.'<br>'); ?>
  
  <ul class="pageNav">
    <li><a onclick="history.back()">&laquo; 前</a></li>
    <li><a href="m06_movieList">1</a></li>
    <li><span>2</span></li>
    <li><a href="m06_movieList">3</a></li>
    <li><a href="m06_movieList">次 &raquo;</a></li>
  </ul>
</body>
</html>