 function debounce(func, wait) {
  let timeout;

  return function () {
    const args = arguments;
    const context = this;

    clearTimeout(timeout)
    timeout = setTimeout(() => {
      func.apply(args,context)
    }, wait); 
  }
}

function Thorttling(func,limit) {
  let lashcall = 0;

  return function () {
    const args = arguments;
    const context = this;
    const now = Date.now()

    if(now - lashcall >= limit) {
      lashcall = now
      func.apply(args,context)
    }
  }
}