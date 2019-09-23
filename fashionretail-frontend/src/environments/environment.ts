// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  // designerUrl : 'http://localhost:8187/api/v1',
  // supplierUrl : 'http://localhost:8188/api/v1',
  // manufacturerUrl : 'http://localhost:8189/api/v1',
  // consumerUrl : 'http://localhost:8190/api/v1',
  // recommendationUrl : 'http://localhost:8191/api/v1',
  // userUrl : 'http://localhost:8192/api/v1',
  // loginUrl : 'http://localhost:8193/api/v1',
  // workflowUrl : 'http://localhost:8194/api/v1',
  // reportsUrl : 'http://localhost:8195/api/v1'

 designerUrl: 'http://13.126.224.142:8280/designer-service/api/v1',
supplierUrl: 'http://13.126.224.142:8280/supplier-service/api/v1',
manufacturerUrl: 'http://13.126.224.142:8280/manufacturer-service/api/v1',
consumerUrl: 'http://13.126.224.142:8280/consumer-service/api/v1',
recommendationUrl: 'http://13.126.224.142:8280/recommendation-service',
userUrl: 'http://13.126.224.142:8280/user-service/api/v1',
loginUrl: 'http://13.126.224.142:8280/login-service/api/v1',
workflowUrl: 'http://13.126.224.142:8280/workflow-service/api/v1',
reportsUrl: 'http://13.126.224.142:8280/reports-service/api/v1'
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
