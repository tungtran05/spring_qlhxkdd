/* get */

if (window.location.href === 'http://127.0.0.1:5500/routeComplexityManagement.html') {
    // get all Route Complexity
    var routeComplexitiesAPI = 'http://localhost:8080/api/routeComplexities';
    fetch(routeComplexitiesAPI)
        .then(function (response) {
            return response.json();
        })
        .then(function (routeComplexities) {
            var htmls = routeComplexities.map(function (routeComplexity) {
                return `<tr>
                        <td>${routeComplexity.id}</td>
                        <td>${routeComplexity.name}</td>
                        <td>${routeComplexity.salaryOfDriver}</td>
                        <td>${routeComplexity.salaryOfDriver / 2}</td>
                        <td>
                            <a href="editRouteComplexity.html">Sửa</a> | 
                            <a href="deleteRouteComplexity.html">Xóa</a>
                        </td>
                        
                    </tr>`;
            })

            setTimeout(function () {
                var html = htmls.join('');
                document.querySelector('table tbody#routeComplexities').innerHTML = html;
            }, 500);
        })
}

if (window.location.href === 'http://127.0.0.1:5500/routeManagement.html') {
    var routesAPI = 'http://localhost:8080/api/routes';
    fetch(routesAPI)
        .then(function (response) {
            return response.json();
        })
        .then(function (routes) {
            var htmls = routes.map(function (route) {
                return `<tr>
                            <td>${route.id}</td>
                            <td>${route.entryPoint}</td>
                            <td>${route.endPoint}</td>
                            <td>${route.routeLength}</td>
                            <td>${route.routeComplexity.name}</td>
                            <td>
                                <a href="editRoute.html">Sửa</a> | 
                                <a href="deleteRoute.html">Xóa</a>
                            </td>
                        </tr>`
            })

            setTimeout(function () {
                var html = htmls.join('');
                document.querySelector('table tbody#routes').innerHTML = html;
            }, 500);
        })
}


if (window.location.href === 'http://127.0.0.1:5500/vehicleManagement.html') {
    var vehiclesAPI = 'http://localhost:8080/api/vehicles';
    fetch(vehiclesAPI)
        .then(function (response) {
            return response.json();
        })
        .then(function (vehicles) {
            var htmls = vehicles.map(function (vehicle) {
                return `<tr>
                            <td>${vehicle.id}</td>
                            <td>${vehicle.licensePlate}</td>
                            <td>${vehicle.color}</td>
                            <td>${vehicle.manufacturer}</td>
                            <td>${vehicle.carLife}</td>
                            <td>${vehicle.model}</td>
                            <td>${vehicle.seatsNum}</td>
                            <td>${vehicle.yearOfUse}</td>
                            <td>${vehicle.lastMaintenance}</td>
                            <td>
                                <a href="editVehicle.html">Sửa</a> | 
                                <a href="deleteVehicle.html">Xóa</a>
                            </td>
                        </tr>`
            })

            setTimeout(function () {
                var html = htmls.join('');
                document.querySelector('table tbody#vehicles').innerHTML = html;
            }, 500);
        })
}


if (window.location.href === 'http://127.0.0.1:5500/staffManagement.html') {
    var staffAPI = 'http://localhost:8080/api/staffs';
    fetch(staffAPI)
        .then(function (response) {
            return response.json();
        })
        .then(function (staffs) {
            var htmls = staffs.map(function (staff) {
                return `<tr>
                        <td>${staff.id}</td>
                        <td>${staff.name}</td>
                        <td>${staff.idCard}</td>
                        <td>${staff.licenseNum}</td>
                        <td>${staff.licenseType}</td>
                        <td>${staff.address}</td>
                        <td>${staff.dob}</td>
                        <td>${staff.seniority}</td>
                        <td>
                            <a href="editStaff.html">Sửa</a> | 
                            <a href="deleteVehicle.html">Xóa</a>
                        </td>
                    </tr>`
            })

            setTimeout(function () {
                var html = htmls.join('');
                document.querySelector('table tbody#staffs').innerHTML = html;
            }, 500);
        })
}



if (window.location.href === 'http://127.0.0.1:5500/tourManagement.html') {
    var toursAPI = 'http://localhost:8080/api/tours';
    fetch(toursAPI)
        .then(function (response) {
            return response.json();
        })
        .then(function (tours) {
            var htmls = tours.map(function (tour) {
                return `<tr>
                        <td>${tour.id}</td>
                        <td>${tour.passengersNum}</td>
                        <td>${tour.fare}</td>
                        <td>${tour.startedAt.substr(0, 10)} ${tour.startedAt.substr(11, 8)}</td>
                        <td>${tour.finishedAt.substr(0, 10)} ${tour.finishedAt.substr(11, 8)}</td>
                        <td>${tour.driver.name}</td>
                        <td>${tour.assistant.name}</td>
                        <td>${tour.vehicle.licensePlate}</td>
                        <td>${tour.route.entryPoint} - ${tour.route.endPoint}</td>
                        <td>
                            <a href="editTour.html">Sửa</a> | 
                            <a href="deleteTour.html">Xóa</a>
                        </td>
                    </tr>`
            })

            setTimeout(function () {
                var html = htmls.join('');
                document.querySelector('table tbody#tours').innerHTML = html;
            }, 500);
        })
}

// audit revenue of vehicles
if (window.location.href === 'http://127.0.0.1:5500/vehicleAudit.html') {
    function handleAuditVehicle() {
        document.getElementById('auditVehicleBtn').onclick = function () {
            var startDate = document.querySelector('div#auditVehicleForm input[name="startDate"]').value;
            var endDate = document.querySelector('div#auditVehicleForm input[name="endDate"]').value;
            // console.log(startDate, endDate);
            var auditVehicleAPI = 'http://localhost:8080/api/auditVehicle?startDate=' + startDate + '&endDate=' + endDate;
            // console.log(auditVehicleAPI);
            fetch(auditVehicleAPI)
                .then(function (response) {
                    return response.json();
                })
                .then(function (auditVehicles) {
                    var htmls = auditVehicles.map(function (auditVehicle) {
                        return `<tr>
                            <td>${auditVehicle[0]}</td>
                            <td>${auditVehicle[1]}</td>
                            <td>${auditVehicle[2]}</td>
                            <td>${auditVehicle[3]}</td>
                            <td>${auditVehicle[4]}</td>
                            <td>${auditVehicle[5]}</td>
                            <td>${auditVehicle[6]}</td>
                            <td>${auditVehicle[7]}</td>
                            <td>${auditVehicle[8]}</td>
                            <td>${auditVehicle[9]}</td>
                        </tr>`
                    })

                    setTimeout(function () {
                        var html = htmls.join('');
                        document.querySelector('table tbody#auditVehicle').innerHTML = html;
                    }, 500);
                })
        }
    }
    handleAuditVehicle();
}

// audit salary of staff
if (window.location.href === 'http://127.0.0.1:5500/salaryOfStaffAudit.html') {
    function handleAuditSalaryOfStaff() {
        document.getElementById('auditSalaryOfStaffBtn').onclick = function () {
            var startDate = document.querySelector('div#auditSalaryOfStaffForm input[name="startDate"]').value;
            var endDate = document.querySelector('div#auditSalaryOfStaffForm input[name="endDate"]').value;
            // console.log(startDate, endDate);
            

            // lấy lương nhân viên
            var auditSalaryDriverAPI = 'http://localhost:8080/api/auditSalaryDriver?startDate=' + startDate + '&endDate=' + endDate;
            var auditSalaryDriver =
                fetch(auditSalaryDriverAPI)
                    .then(function (response) {
                        return response.json();
                    })
                    .then(function(mutilSalary) {
                        var htmls = mutilSalary.map(function(salary) {
                            return `<tr>
                                        <td>${salary[0]}</td>
                                        <td>${salary[1]}</td>
                                        <td>${salary[2]}</td>
                                        <td>${salary[3]}</td>
                                        <td>${salary[4]}</td>
                                    <tr>`
                        })
                        setTimeout(function () {
                            var html = htmls.join('');
                            document.querySelector('table tbody#auditStaff').innerHTML = html;
                        }, 500);
                    })

            

        }
    }
    handleAuditSalaryOfStaff();
}


/* add */

if (window.location.href === 'http://127.0.0.1:5500/addRouteComplexity.html') {
    // add Route Complexity
    var routeComplexitiesAPI = 'http://localhost:8080/api/routeComplexities';
    document.getElementById('btnAddRouteComplexity').onclick = function () {
        var level = document.getElementById('levelOfRoute').value;
        var salary = document.getElementById('salaryDriverOfRoute').value;
        var data = {
            name: level,
            salaryOfDriver: salary
        };
        console.log(data);
        handleAddRouteComplexity(data);
    }
    function handleAddRouteComplexity(data) {
        fetch(routeComplexitiesAPI, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
            .then(function (response) {
                response.json();
            })
    }
}


function handleAddRouteComplexityForm() {

    document.getElementById('btnAddRouteComplexity').onclick = function () {
        var level = document.getElementById('levelOfRoute').value;
        var salary = document.getElementById('salaryDriverOfRoute').value;
        var data = {
            name: level,
            salaryOfDriver: salary
        };
        handleAddRouteComplexity(data);
    }
}

function handleAddRouteComplexity(data) {
    fetch(routeComplexitiesAPI, {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(function (response) {
            response.json();
        })

}

// handleAddRouteComplexityForm();

