# CLI-kkolesn1

A small Java command line tool that does a few simple text operations.

## Commands
- `hash` - prints SHA-256 hash of text
- `reverse` - reverses text
- `count` - shows number of characters
  -  `--words` - added by the end counts words as well

## Usage
```bash
javac Main.java
java Main hash --text Hello
java Main reverse --text Hello
java Main count --text "Hello world" [--words]
