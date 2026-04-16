# Change Log

## 16.0.0

* [BREAKING] Renamed Webhook model fields: `security` → `tls`, `httpUser` → `authUsername`, `httpPass` → `authPassword`, `signatureKey` → `secret`
* [BREAKING] Renamed Webhook service parameters to match: `security` → `tls`, `httpUser` → `authUsername`, `httpPass` → `authPassword`
* Added `secret` parameter to Webhook create and update methods
* Added `x` OAuth provider to `OAuthProvider` enum
* Added `userType` field to `Log` model
* Added `purge` parameter to `updateCollection` and `updateTable` for cache invalidation
* Added Project service: platform CRUD, key CRUD, protocol/service status management
* Added new models: `Key`, `KeyList`, `PlatformAndroid`, `PlatformApple`, `PlatformLinux`, `PlatformList`, and others
* Added new enums: `PlatformType`, `ProtocolId`, `ServiceId`
* Updated `BuildRuntime`, `Runtime`, `Scopes` enums with new values
* Updated `X-Appwrite-Response-Format` header to `1.9.1`
* Updated TTL description for list caching in Databases and TablesDB

## 15.0.0

* [BREAKING] Changed `$sequence` type from `int` to `string` for rows and documents
* Breaking: Renamed `IndexType` to `DatabasesIndexType` in docs.
* Breaking: Replaced `.setKey()` with `.setSession()` in docs examples.
* Updated: Updated docs to reflect new `DatabasesIndexType` examples.

## 14.1.0

* Added getConsolePausing health status endpoint
* Added `ttl` parameter for cached list results (0-86400s)
* Added optional `activate` parameter to Sites.createDeployment
* Updated Document and Row sequence ID descriptions
* Updated Databases docs to refer to collections, not tables
* Added deprecated updateRelationshipAttribute public API; use TablesDB.updateRelationshipColumn instead

## 14.0.1

* Documentation updates: Added new encrypt (optional) parameter to attribute and column creation examples in Java and Kotlin docs to support encryption for database fields.
* Updated README to reflect compatibility with Appwrite server version 1.8.x and aligned the Kotlin SDK dependency examples to version 14.0.0.
* Misc: Removed obsolete GitHub workflows from the repository as part of cleanup.
* Add support for the new `Backups` service

## 14.0.0

* Add array-based enum parameters (e.g., `permissions: List<BrowserPermission>`).
* Breaking change: `Output` enum has been removed; use `ImageFormat` instead.
* Add `getQueueAudits` support to `Health` service.
* Add longtext/mediumtext/text/varchar attribute and column helpers to `Databases` and `TablesDB` services.

## 13.1.0

* Added ability to create columns and indexes synchronously while creating a table

## 13.0.0

* Rename `VCSDeploymentType` enum to `VCSReferenceType`
* Change `createTemplateDeployment` method signature: replace `version` parameter with `type` (TemplateReferenceType) and `reference` parameters
* Add `getScreenshot` method to `Avatars` service
* Add `Theme`, `Timezone` and `Output` enums

## 12.3.0

* Add `total` parameter to list queries allowing skipping counting rows in a table for improved performance
* Add `Operator` class for atomic modification of rows via update, bulk update, upsert, and bulk upsert operations
* Add `createResendProvider` and `updateResendProvider` methods to `Messaging` service

## 12.2.1

* Add transaction support for Databases and TablesDB

## 12.1.0

* Deprecate `createVerification` method in `Account` service
* Add `createEmailVerification` method in `Account` service

## 9.1.0

* Add `incrementDocumentAttribute` and `decrementDocumentAttribute` support to `Databases` service
* Add `dart38` and `flutter332` support to runtime models
* Add `gif` support to `ImageFormat` enum
* Add `encrypt` support to `StringAttribute` model
* Add `sequence` support to `Document` model

## 9.0.0

* Add `<REGION>` to doc examples due to the new multi region endpoints
* Add doc examples and methods for bulk api transactions: `createDocuments`, `deleteDocuments` etc.
* Add doc examples, class and methods for new `Sites` service
* Add doc examples, class and methods for new `Tokens` service
* Add enums for `BuildRuntime `, `Adapter`, `Framework`, `DeploymentDownloadType` and `VCSDeploymentType`
* Update enum for `runtimes` with Pythonml312, Dart219, Flutter327 and Flutter329
* Add `token` param to `getFilePreview` and `getFileView` for File tokens usage
* Add `queries` and `search` params to `listMemberships` method
* Remove `search` param from `listExecutions` method

## 8.0.0

* Fix requests failing by removing `Content-Type` header from `GET` and `HEAD` requests

## 7.0.0

* Fix pong response & chunked upload
