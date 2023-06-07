const form = document.querySelector("#contact-form");
const status = document.querySelector("#status");

form.addEventListener("submit", function(event) {
  event.preventDefault();
  const formData = new FormData(form);
  const xhr = new XMLHttpRequest();
  xhr.open("POST", "contact.php");
  xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4) {
      if (xhr.status === 200) {
        status.innerHTML = "메시지 전송 완료!";
        form.reset();
      } else {
        status.innerHTML = "메시지 전송 실패!";
      }
    }
  };
  xhr.send(new URLSearchParams(formData).toString());
});