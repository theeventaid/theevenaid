const getLatLng = () => {
    let coords = {}
    navigator.geolocation.getCurrentPosition((position) => {
        coords.lat = position.coords.latitude;
        coords.lng = position.coords.longitude;
    });
    return coords;
};