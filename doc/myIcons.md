## Useful Icons

❓✔️❌❗️⚡️📄📝📌🔨💡☝️👉👇☝️👍👎👌💾🗑🐛📒⚠️😄😢♻️🔥🛠📐🎯✉️☎️

## Color picker
[Pick color website](https://www.webfx.com/web-design/color-picker/)

## math symbols
|operator | LaTex Symbols |
|---------|---------------|
× | times
÷ | div
± | pm
° | degree
∞ | infty
ϕ | phi
Φ | Phi
θ | theta
α | alpha
β | beta
γ | gamma
δ | delta
μ | mu
π | pi
λ | lambda
ω | omega
⇒ | Rightarrow
⟹| Longrightarrow
⇓ | Downarrow

## Sample File Structure:

```output
<project root>
    ├── 📝doc/
    |    ├── mistakes.md 
    |    ├── vscodeTrics.md 
    |    └── python.md 
    ├── 🔨homeworks/
    |       └── <filenameXX.md>
    ├── 🔥src/
    |      └── hello.py 
    └── 👉ReadMe.md
```

## Sample Mermaid Diagram

```mermaid
graph LR
START((start))
B[code block]
END[end]
IF{condition<br> block}
DB[(database)]

START-->IF
IF--True-->DB-->END
IF--False-->B-->END

classDef html fill:#F46624,stroke:#F46624,stroke-width:4px,color:white;
classDef js fill:yellow,stroke:black,stroke-width:2px;
classDef if fill:#EBCD6F,stroke:black,stroke-width:2px;
classDef db fill:#BEBDB7,stroke:black,stroke-width:2px;
classDef start fill:green,stroke:#DE9E1F,stroke-width:2px,color:white;
classDef end1 fill:red,stroke:#DE9E1F,stroke-width:2px,color:white;

class START start
class B,D,E js
class IF if
class DB db
class END end1
```

