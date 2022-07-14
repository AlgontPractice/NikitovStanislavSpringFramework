const starts = document.querySelectorAll('.start');
console.log(starts)

starts.forEach((element) => {
    element.addEventListener('click', function (e) {
        stops[0].removeAttribute('disabled');
        starts[0].setAttribute('disabled', true);
        console.log(e.target);
        const data = {
        }
        fetch('http://localhost:8082/recorder/start', {
            method: "POST",
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify(data)
        });
    })
})