# Change Log

## 23.0.0

* Breaking: `account.listLogs`, `users.listLogs`, `Log` and `LogList` removed
* Breaking: `organization` key methods renamed to `createEphemeralProjectKey`, `getProjectKey`, `listProjectKeys`, `updateProjectKey` and `deleteProjectKey`; `OrganizationKeyScopes` removed
* Breaking: `setDevKey` client method, `DevKey` model and `Project.devKeys` removed
* Breaking: `projectName`, `region`, `organizationId`, `organizationName`, `billingPlan` and `reason` removed from `Block`
* Breaking: `DedicatedDatabaseSpecificationList.pricing` and `DedicatedDatabaseSpecificationPricing` removed; rates now live on `DedicatedDatabaseSpecification`
* Breaking: `BillingPlanGroup` `starter` replaced by `free` and `start`
* Breaking: `resource` is now an array on `oauth2.authorize`, `oauth2.createPAR`, `oauth2.createToken` and `oauth2.createDeviceAuthorization`
* Breaking: `BackupRestoration.options` is now a key-value object instead of a string
* Breaking: several model fields are now nullable, e.g. `DedicatedDatabase.engine`, `Organization.billingStartDate`, `BillingPlan.usage`, `BackupArchive.size`
* Breaking: optional parameters reordered in `messaging.updateEmail`, `messaging.updatePush` and `messaging.updateSMS`; new ones inserted mid-list in `messaging.createEmail`, `teams.createMembership` and `project` OAuth2 provider updates; use named arguments
* Added: passkey methods `account.listPasskeys`, `account.createPasskey`, `account.getPasskey`, `account.updatePasskey`, `account.deletePasskey`, `account.updatePasskeyVerification`, `account.createPasskeyToken` and `account.updatePasskeyToken`
* Added: `users.listPasskeys`, `users.getPasskey`, `users.updatePasskey`, `users.deletePasskey`, plus `project.updatePasskeyPolicy`
* Added: `Passkey`, `PasskeyList`, `PasskeyChallenge`, `PolicyPasskey` and `TokenSecret` models
* Added: `fingerprints` on Android platforms for passkeys
* Added: `domains` service for domains, DNS records, email presets, prices and transfers
* Added: `waf` service for bypass, challenge, deny, rate-limit and redirect rules
* Added: `account.createIdTokenSession` for native Apple and Google sign-in, with native client IDs on those providers
* Added: email verification and recovery OTP methods on `account`
* Added: `oauth2.introspect` for RFC 7662 token introspection, returning `Oauth2Introspection`
* Added: `avatars.updatePhoto` and `avatars.deletePhoto`
* Added: `messaging.createAppwriteProvider` and `messaging.updateAppwriteProvider`
* Added: `project.updatePasswordPwnedPolicy`, `PolicyPasswordPwned` model and `User.passwordPwned`
* Added: Kakao, TikTok and Webflow OAuth2 providers
* Added: `prompt` on Auth0, Discord, GitHub, Microsoft, Okta, Salesforce and Zoho providers, with prompt enums
* Added: `Topic` and `ResolvedTopic` helpers for building MQTT push topics
* Added: reply-to on email messages, `channelId` on push messages, `qos` and `expiry` on topics
* Added: `membershipId` on `teams.createMembership`, and `total` on locale and other list endpoints
* Added: `storageStatus` and `storageTargetGb` on `DedicatedDatabase`; `eligibleCountries` on `BillingPlan`
* Added: `auto` image gravity, `jaspr` framework, `dart-3.13` and `flutter-3.47` runtimes
* Added: `project.updatePasswordRotationPolicy` and the `PolicyPasswordRotation` model
* Fixed: response models fill missing fields from spec defaults instead of throwing
* Fixed: object parameters in multipart requests are sent as JSON
* Updated: requests send `X-Appwrite-Response-Format` `2.4.0`
* Updated: Kotlin bumped to `2.4.20`

## 22.2.0

* Added: optional `interval` parameter on `functions.create` and `functions.update` to run a function every N minutes
* Added: `interval` on the `Function` model and `functionsIntervalMinimum` on the `BillingPlan` model

## 22.1.0

* Added: optional `state` parameter on `createOAuth2Token`, returned unchanged on the success and failure URLs

## 22.0.0

* Stable release of the dedicated database APIs: `mysql`, `postgresql`, `mongo`, `documentsDB`, and `vectorsDB` services, previously released as release candidates
* Breaking: `tablesDB.cutoverMigration` is renamed to `tablesDB.createCutover`
* Added: Cloudflare and Resend OAuth providers
* Added: `usageAggregateOnlyMetrics` on the `BillingPlan` model
* Fixed: `transactionId` is accepted again by `documentsDB` and `vectorsDB` `createDocument` and `createDocuments`
* Updated: `X-Appwrite-Response-Format` is now `2.0.0`
* Updated: `FrameworkAdapter.fallbackFile` is now optional

## 22.0.0-rc.1

* Breaking: `EmbeddingModel` no longer offers `embedding-gemma` or `bge-small`
* Added: `documentsDB`, `vectorsDB`, `mysql`, `postgresql`, and `mongo` services, no longer hidden from server SDKs
* Added: `DocumentsDBIndexType` and `VectorsDBIndexType` enums
* Added: dedicated database models for branches, backups, restorations, poolers, PITR windows, extensions, and executions
* Added: `PostgresExtension`, `VectorsdbCollection`, `AttributeObject`, and `AttributeVector` models
* Added: `userId`, `emailHash`, and `name` parameters to `avatars.getPhoto`
* Added: `error`, `containerStatus`, and `lifecycleState` on the `Database` model
* Added: `changelogWatermark` on the `DatabaseMigration` model
* Added: `total` on the `DedicatedDatabaseBranchList` model
* Updated: `DedicatedDatabaseOperation.status` documents the new `queued` state

## 21.0.0

* Breaking: object parameters and model fields are now typed `Map<String, Any?>` instead of `Any`
* Fixed: passing `null` in `data` now clears the attribute instead of being dropped from the request
* Added: `project.updateOAuth2HuggingFace` and the `OAuth2HuggingFace` model
* Added: `avatars.getPhoto`
* Added: `ExecutionResourceType` enum

## 20.0.0

* Breaking: removed `account.createJWT`; use `users.createJWT` instead. A leaked JWT could mint further JWTs, letting a credential outlive its own expiry — a session cannot duplicate itself to live forever either
* Breaking: removed `project.createKey`. A leaked key could mint further hidden keys, making a compromise far harder to contain and revoke
* Breaking: `activities.listEvents` `queries` now takes an array instead of a string
* Added: `embeddings` service with `createTextEmbeddings`, plus the `EmbeddingModel` enum
* Added: TablesDB migration methods `listMigrations`, `createMigration`, `getMigration`, `deleteMigration`, `cutoverMigration`, and `listOperations`
* Added: `proxy.createInvalidation` for purging cached edge responses, plus the `InvalidationType` enum
* Added: `apps.deleteInstallation`
* Added: `users.getMFAChallenge` and the `MfaChallengeSecret` model
* Added: `project.updateMFAFactorsPolicy` and the `PolicyMfaFactors` model
* Added: `client.setOrganization` for organization-scoped requests
* Added: `folder` parameter to `storage.createFile`
* Added: `syncMode` parameter to `tablesDB.create` and `tablesDB.update`, and `specification` to `tablesDB.update`
* Added: `installationScopes` parameter to `project.updateOAuth2Server`
* Added: `custom` authentication factor, `node-26` runtime, `mfa-factors` project policy, and the `embeddings.write` and `proxy.invalidations.write` key scopes
* Updated: response format to `1.9.6`

## 19.1.0

* Added: `Apps` service for managing OAuth2 applications, keys, and installations
* Added: `OAuth2` service with authorize, grant, device authorization, and consent flows
* Added: account OAuth2 consent methods `listConsents`, `getConsent`, `deleteConsent`, and consent token methods
* Added: app installation management methods to `Organization` and `Teams` services
* Added: `installationAccessTokenDuration` parameter to `project.updateOAuth2Server`
* Added: `token` parameter to `sites.getDeploymentDownload`
* Added: `oauth2.introspect` and organization installation key scopes

## 19.0.0

* Breaking: Removed `Health` and `Usage` services with their models and enums
* Breaking: Removed `Messaging` methods `listMessageLogs`, `listProviderLogs`, `listSubscriberLogs`, `listTopicLogs`
* Breaking: Removed OS, client, and device fields from `ActivityEvent` model
* Breaking: Changed geometry `default` parameter types from `List<Any>` to typed nested lists
* Breaking: Made `Project` OAuth2 server model fields nullable
* Added: `Organization` `get`, `update`, `delete`, and membership management methods
* Added: `Project.updateOAuth2Appwrite` and `Project.updateDenyCorporateEmailPolicy` methods
* Added: `Client.setBearer` for bearer token authentication
* Added: `Query.vectorDot`, `Query.vectorCosine`, `Query.vectorEuclidean` vector query helpers
* Added: `BillingPlan` models and `BillingPlanGroup`, `DatabaseStatus`, `OAuth2OidcPrompt` enums
* Added: `appwrite` OAuth provider and organization, `stages`, `oauth2`, `dedicatedDatabases` key scopes
* Added: geolocation fields (`city`, `timeZone`, `latitude`, ISP) to `Locale` model
* Added: email classification fields (`emailIsFree`, `emailIsDisposable`, `emailIsCorporate`) to `User` model
* Added: OIDC `prompt`/`maxAge` and device-code OAuth2 server parameters on `Project`
* Added: `newSpecification` to `Backups.createRestoration`; `type`, `token` parameters in `Functions`
* Updated: deprecated `Databases` transaction and text-column methods in favor of `TablesDB`

## 18.1.0

* Added: `createSesProvider` and `updateSesProvider` to `messaging`
* Added: `updateOAuth2Server` to `project` for OAuth2 server settings
* Added: `updatePasswordStrengthPolicy` and `PolicyPasswordStrength` to `project`
* Added: `getAuditsDB` health check to `health`
* Added: `password-strength` to `ProjectPolicyId`
* Added: `apps.read` and `apps.write` to `ProjectKeyScopes`


## 18.0.0

* Breaking: Removed `githubImagine` and `googleImagine` from `ProjectOAuthProviderId`
* Breaking: Removed `deno-1.21`, `deno-1.24`, and `deno-1.35` from `Runtime` and `BuildRuntime`
* Breaking: Dropped numeric suffixes from `StatusCode` redirect members
* Added: `Organization` service for managing projects and API keys
* Added: `PolicyDenyAliasedEmail`, `PolicyDenyDisposableEmail`, and `PolicyDenyFreeEmail` policy models
* Added: `deny-aliased-email`, `deny-disposable-email`, and `deny-free-email` to `ProjectPolicyId`
* Replaced: `BrowserTheme`, `HealthQueueName`, `OrganizationKeyScopes`, and `Region` enums
* Added: `dart-3.12` and `flutter-3.44` runtimes
* Added: `ProjectList` model and new attributes on `Function`, `Site`, and `UsageGauge`
* Updated: `functions`, `sites`, `usage`, `health`, and `avatars` services
* Updated: Renamed `updatePresence` to `update` in the `presences` service

## 17.0.0

* Breaking: Renamed `AuthMethod` enum to `ProjectAuthMethodId`
* Breaking: Renamed `EmailTemplateType` to `ProjectEmailTemplateId` and `EmailTemplateLocale` to `ProjectEmailTemplateLocale`
* Breaking: Renamed `ServiceId` to `ProjectServiceId`, `ProtocolId` to `ProjectProtocolId`, `Secure` to `ProjectSMTPSecure`, `ProjectPolicy` to `ProjectPolicyId`
* Breaking: Replaced `Scopes` enum with `ProjectKeyScopes` for project key endpoints
* Breaking: Removed `Project.updateDenyCanonicalEmailPolicy`; replaced with `updateDenyAliasedEmailPolicy`, `updateDenyDisposableEmailPolicy`, and `updateDenyFreeEmailPolicy`
* Breaking: Removed `AuthProvider` model; use new `ProjectOAuthProviderId` enum instead
* Added: `Project.get` method to fetch current project details
* Added: `Advisor`, `Presences`, and `Usage` services
* Added: `Insight`, `Presence`, `Report`, `UsageEvent`, and `UsageGauge` models with list variants
* Added: `ProjectAuthMethod`, `ProjectProtocol`, and `ProjectService` models
* Added: `ProjectOAuthProviderId` and `ProjectOAuth2GooglePrompt` enums
* Updated: `Project`, `Database`, and `OAuth2Google` model schemas
* Updated: Migrated Gradle build files to Kotlin DSL (`build.gradle.kts`)
* Updated: `X-Appwrite-Response-Format` header to `1.9.5`

## 16.1.0

* Added: Introduced `bigint` create/update APIs for legacy Databases attributes
* Added: Introduced `bigint` create/update APIs for `TablesDB` columns
* Updated: Extended key-list query filters with `key`, `resourceType`, `resourceId`, and `secret`

## 16.0.0

* [BREAKING] Renamed Webhook model fields: `security` → `tls`, `httpUser` → `authUsername`, `httpPass` → `authPassword`, `signatureKey` → `secret`
* [BREAKING] Renamed Webhook service parameters to match: `security` → `tls`, `httpUser` → `authUsername`, `httpPass` → `authPassword`
* [BREAKING] Renamed `Webhooks.updateSignature()` to `Webhooks.updateSecret()` with new optional `secret` parameter
* Added `Client.getHeaders()` method to retrieve request headers
* Added `secret` parameter to Webhook create and update methods
* Added `x` OAuth provider to `OAuthProvider` enum
* Added `userType` field to `Log` model
* Added `purge` parameter to `updateCollection` and `updateTable` for cache invalidation
* Added Project service: platform CRUD, key CRUD, protocol/service status management
* Added new models: `Key`, `KeyList`, `Project`, `DevKey`, `MockNumber`, `AuthProvider`, `PlatformAndroid`, `PlatformApple`, `PlatformLinux`, `PlatformList`, `PlatformWeb`, `PlatformWindows`, `BillingLimits`, `Block`
* Added new enums: `PlatformType`, `ProtocolId`, `ServiceId`
* Updated `BuildRuntime`, `Runtime` enums with `dart-3.11` and `flutter-3.41`
* Updated `Scopes` enum with `keysRead`, `keysWrite`, `platformsRead`, `platformsWrite`
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
