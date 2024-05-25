a parser that determines if a JSON file is valid or not.


1. **Compile the Java files:**
    ```sh
    javac org/example/App.java org/example/Lexer.java org/example/Parser.java
    ```

2. **Run the parser with a JSON file:**
    ```sh
    java org.example.App path/to/your/json/file.json
    ```

### Example

**File: `valid.json`**
```json
{
  "key1": true,
  "key2": false,
  "key3": null,
  "key4": "value",
  "key5": 101,
  "key6": 3.14,
  "key7": {
    "nestedKey": "nestedValue"
  },
  "key8": [1, 2, 3, "four"]
}
```

**Run:**
```sh
java org.example.App valid.json
```

**Output:**
```
Valid JSON
```

**File: `invalid.json`**
```json
{
  "key1": true,
  "key2": "invalid,
  "key3": null,
  "key4": "value",
  "key5": 101
}
```

**Run:**
```sh
java org.example.App invalid.json
```

**Output:**
```
Invalid JSON
```