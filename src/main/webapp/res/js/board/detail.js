function isDelCmt(iboard, icmt) {
    console.log(icmt);
    
    if(confirm('댓글을 삭제 하시겠습니까?')) {
        location.href = '/board/cmt/del?iboard=' + iboard + '&icmt=' + icmt;
    }
}