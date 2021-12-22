function moveToDetail(iboard) {
    console.log('iboard : ' + iboard);
    location.href="/board/detail2?iboard=" + iboard;
}

var searchFrmElem = document.querySelector('#searchFrm');
console.log(searchFrmElem);
if(searchFrmElem) {
    searchFrmElem.rowCnt.addEventListener('change', function() {
        searchFrmElem.submit();
    });
}