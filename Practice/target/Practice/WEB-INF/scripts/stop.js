const stops = document.querySelectorAll('.stop');
console.log(stops)

stops.forEach((element) => {
    element.addEventListener('click', function (e) {
        starts[0].removeAttribute('disabled');
        stops[0].setAttribute('disabled', true);
        console.log(e.target);
        const data = {
        }
        fetch('http://localhost:8082/recorder/stop', {
            method: "POST",
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify(data)
        });
    })
})