$(document).ready(function() {
    $('#calendar').fullCalendar({
        // Your FullCalendar options and configurations here
        events: '/api/events', // Your Spring Boot endpoint to fetch events
        // other options...
    });
});
