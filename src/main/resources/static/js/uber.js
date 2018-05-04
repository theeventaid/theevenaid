const apiURI = "https://sandbox-api.uber.com/v1.2";

const getFareEstimate = (s_lat, s_lng, e_lat, e_lng) => new Promise((resolve, reject) => {
    fetch(`${apiURI}/requests/estimate`, {
        method: 'POST',
        body: JSON.stringify({
            start_latitude: s_lat,
            start_longitude: s_lng,
            end_latitude: e_lat,
            end_longitude: e_lng
        }),
        headers: new Headers({
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${UBER_TOKEN}`
        })
    }).then(res => res.json()).catch(error => reject(error)).then(data => resolve(data));
});

const requestRide = (fare_id, s_lat, s_lng, e_lat, e_lng) => new Promise((resolve, reject) => {
    fetch(`${apiURI}/requests`, {
        method: 'POST',
        body: JSON.stringify({
            fare_id: fare_id,
            start_latitude: s_lat,
            start_longitude: s_lng,
            end_latitude: e_lat,
            end_longitude: e_lng
        }),
        headers: new Headers({
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${UBER_TOKEN}`
        })
    }).then(res => res.json()).catch(error => reject(error)).then(data => resolve(data));
});

$(document).ready(() => {
    getFareEstimate(37.7752278, -122.4197513, 37.7773228, -122.4272052).then( info => {
        console.log(info);
    });
});
