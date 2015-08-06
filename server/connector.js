var AWS = require('aws-sdk');

var devicefarm = new AWS.DeviceFarm({region: 'us-west-2'});

var params = {
    name: './app/build/outputs/apk/app-debug.apk', /* required */
    projectArn: '',
    type: 'ANDROID_APP',
    //region: 'us-west-2',
    contentType: 'application/octet-stream'
};

var apkFileArn = "";
var testFileArn = "";

devicefarm.createUpload(params, function(err, data) {
    if (err) console.log(err, err.stack); // an error occurred
    else     { // successful response
            console.log(data);
            apkFileArn = data.upload.arn;
            //console.log('arn:' + apkFileArn);
        }
});

params.name = './app/build/outputs/libs/myapp-api.jar';

devicefarm.createUpload(params, function(err, data) {
    if (err) console.log(err, err.stack); // an error occurred
    else {
        console.log(data);           // successful response
        testFileArn = data.upload.arn;
    }
});