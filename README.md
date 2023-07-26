# Rosetta.Siegfried-FormatIdentificationPlugin
## Signature file update
The identification plugin tool is currently using the latest signature provided with Siegried 1.10.1
>siegfried 1.10.1
>identifiers:
>&emsp; \- pronom: DROID_SignatureFile_V112.xml; container-signature-20230510.xml

To update the signature file:

 1. Update the default.sig file under conf directory.
>The signature file should be compatible with the respective Siegfried tool version.
> i.e. Signature files for 1.9.5 are not compatible with 1.10+

2. Increase the pl:version in the src/PLUGIN-INF/metadata_FFSiegfriedIdentificator.xml
3. Build the plugin
4. Add the plugin to the server and restart the server.

## Siegfried tool update
Siegfried tool is provided OOTB 
To use a different Siegfried executable version:
1.  Install the Siegfried executable to the server
2.  Change the soft link sf to point to the new executable
3.  Update the signature file default.sig under conf directory.
4. Build the plugin
5. Add the plugin to the server and restart the server.
## Note
This is the SiegfriedIdentificationPlugin.jar provided with Rosetta 8.0
> This won't work on previous Rosetta versions (7.4.0+)
> To use with previous Rosetta version (7.4.0+), use compatible Siegfried signature with the Siegfried executable on the server as explained above