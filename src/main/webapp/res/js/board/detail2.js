var cmtListContainerElem = document.querySelector('#cmtListContainer');

function getList() {
    var url = '/board/cmt?iboard=' + cmtListContainerElem.dataset.iboard;
    fetch(url).then(function(res) {
        return res.json();
    }).then(function(data) {
        console.log(data);
    }).catch(function(err) {
        console.error(err);
    });
}
getList();