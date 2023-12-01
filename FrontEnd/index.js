
function createStudent(studentData) {
    $.ajax({
        url: 'http://localhost:8080/student',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(studentData),
        success: function (data) {
            console.log('Student created successfully:', data);
            fetchStudents();
        },
        error: function (error) {
            console.error('Error creating student:', error);
        }
    });
}

$('#userForm').submit(function (event) {
    event.preventDefault(); // Prevents the default form submission

    const formData = {
        firstName: $('#firstName').val(),
        lastName: $('#lastName').val(),
        phone: $('#phone').val(),
        dob: $('#dob').val(),
        gender: $('#gender').val(),
        address: $('#address').val()
    };

    createStudent(formData);
});


// ------------------------------------------------
function fetchStudents() {
    $.ajax({
        url: 'http://localhost:8080/student',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            displayStudents(data);
        },
        error: function (error) {
            console.error('Error fetching students:', error);
        }
    });
}


function displayStudents(students) {
    console.log(students);
    const studentListContainer = $('.student-list');


    studentListContainer.empty();


    const table = $('<table>').addClass('student-table');
    const tableHeader = $('<tr>').addClass('student-table-header');
    tableHeader.append('<th>ID</th>');
    tableHeader.append('<th>Name</th>');
    tableHeader.append('<th>Phone</th>');
    tableHeader.append('<th>Date of Birth</th>');
    tableHeader.append('<th>Gender</th>');
    tableHeader.append('<th>Address</th>');
    table.append(tableHeader);


    students.forEach(student => {
        const row = $('<tr>').addClass('student-table-row');
    
        row.append(`<td>${student.id}</td>`);
        row.append(`<td>${student.firstName} ${student.lastName}</td>`);
        row.append(`<td>${student.phone}</td>`);
        row.append(`<td>${student.dob}</td>`);
        row.append(`<td>${student.gender}</td>`);
        row.append(`<td>${student.address}</td>`);
        row.append(`<td><button onclick="editStudent(${student.id})">Edit</button></td>`);
        row.append(`<td><button style='background-color: red; color: white;' onclick="deleteStudent(${student.id})">Delete</button></td>`);
    
        table.append(row);
    });

    studentListContainer.append(table);
}


let editingStudentId = null;

function editStudent(studentId) {
    // Set the global variable to keep track of the student being edited
    editingStudentId = studentId;

    // Retrieve the student details using AJAX
    $.ajax({
        url: `http://localhost:8080/student/${studentId}`,
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            // Pre-fill the form with the student details
            $('#firstName').val(data.firstName);
            $('#lastName').val(data.lastName);
            $('#phone').val(data.phone);
            $('#dob').val(data.dob);
            $('#gender').val(data.gender);
            $('#address').val(data.address);
        },
        error: function (error) {
            console.error('Error fetching student details for editing:', error);
        }
    });
}

// Modify the form submission to handle both adding and updating students
$('#userForm').submit(function (event) {
    event.preventDefault(); // Prevents the default form submission

    const formData = {
        firstName: $('#firstName').val(),
        lastName: $('#lastName').val(),
        phone: $('#phone').val(),
        dob: $('#dob').val(),
        gender: $('#gender').val(),
        address: $('#address').val()
    };

    if (editingStudentId) {
        // If editingStudentId is set, update the existing student
        updateStudent(editingStudentId, formData);
    } else {
        // If editingStudentId is not set, create a new student
        createStudent(formData);
    }
});

function updateStudent(studentId, studentData) {
    $.ajax({
        url: `http://localhost:8080/student/${studentId}`,
        type: 'PUT', // Assuming your server supports PUT for updating
        contentType: 'application/json',
        data: JSON.stringify(studentData),
        success: function (data) {
            console.log('Student updated successfully:', data);
            fetchStudents();
            // Reset the global variable after updating
            editingStudentId = null;
        },
        error: function (error) {
            console.error('Error updating student:', error);
        }
    });
}




function deleteStudent(studentId) {
    const confirmation = confirm('Are you sure you want to delete this student?');
    if (!confirmation) {
        return;
    }

    $.ajax({
        url: `http://localhost:8080/student/${studentId}`,
        type: 'DELETE',
        success: function (data) {
            console.log('Student deleted successfully:', data);
            fetchStudents();
        },
        error: function (error) {
            console.error('Error deleting student:', error);
        }
    });
}

fetchStudents();