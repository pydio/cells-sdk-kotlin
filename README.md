# Pydio Cells SDK for kotlin

[Kotlin](https://kotlinlang.org/) SDK for communicating with a Pydio Cells Server.

This is the playground to build next generation of the Cells Android app based on the **API v1**.

> WARNING: If you are rather looking for the SDK for the Cells API **v2**, e.g. for Wire Cells
> integrations,
> rather checkout the [v5-dev branch](https://github.com/pydio/cells-sdk-kotlin/tree/v5-dev)

This repository mainly contains:

- an automatically generated API client
  using  [Open Api Generator](https://openapi-generator.tech/docs/generators/kotlin/), using default
  recommended options
- a transport layer that handles authentication and wraps AWS SDK for file transfers
- a minimalistic app that use this SDK to perform simple actions on a running Cells
  server instance [WIP we slowly migrate old PoC]

## License

This library is licensed under Apache v2.0 license.