const elements = document.querySelectorAll('.clicker');
console.log(elements);

elements.forEach((element) => {
    element.addEventListener('click', function (e) {
        //----------------------------------------------------------------------
        elements.forEach((el) => {
            el.classList.remove('active')});
        e.target.closest('table').classList.add('active');
        console.log(e.target);
        //-----------------------------------------------------------------------
        const source = e.target.closest('table').getAttribute('datasrc');
        console.log(source);
        parent.postMessage(source, "*")});
})
window.addEventListener('message', (e) => {
    const sources = document.querySelector('source');
    sources.setAttribute("src", e.data);
    document.getElementById('videoId').load();
    document.getElementById('videoId').play();
    console.log('Helllo' + document.getElementById('videoId'));
})