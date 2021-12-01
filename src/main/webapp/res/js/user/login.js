var frm = document.querySelector('#frm');
if(frm) {
    frm.addEventListener('submit', function(e) {
        alert('전송!!!');
        e.preventDefault();
    });
}