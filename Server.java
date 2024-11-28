<html>
<head>
<title>Server.java</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
.s0 { color: #cf8e6d;}
.s1 { color: #bcbec4;}
.s2 { color: #bcbec4;}
.s3 { color: #7a7e85;}
.s4 { color: #2aacb8;}
.s5 { color: #6aab73;}
</style>
</head>
<body bgcolor="#1e1f22">
<table CELLSPACING=0 CELLPADDING=5 COLS=1 WIDTH="100%" BGCOLOR="#606060" >
<tr><td><center>
<font face="Arial, Helvetica" color="#000000">
Server.java</font>
</center></td></tr></table>
<pre><span class="s0">import </span><span class="s1">java</span><span class="s2">.</span><span class="s1">io</span><span class="s2">.*;</span>
<span class="s0">import </span><span class="s1">java</span><span class="s2">.</span><span class="s1">net</span><span class="s2">.*;</span>

<span class="s3">//ALI</span>
<span class="s0">abstract class </span><span class="s1">Shape </span><span class="s0">implements </span><span class="s1">Serializable </span><span class="s2">{</span>
    <span class="s0">public abstract double </span><span class="s1">getArea</span><span class="s2">();</span>
    <span class="s0">public abstract </span><span class="s1">String getDetails</span><span class="s2">();</span>
<span class="s2">}</span>

<span class="s0">class </span><span class="s1">Circle </span><span class="s0">extends </span><span class="s1">Shape </span><span class="s2">{</span>
    <span class="s0">private double </span><span class="s1">radius</span><span class="s2">;</span>

    <span class="s0">public </span><span class="s1">Circle</span><span class="s2">(</span><span class="s0">double </span><span class="s1">radius</span><span class="s2">) {</span>
        <span class="s0">this</span><span class="s2">.</span><span class="s1">radius </span><span class="s2">= </span><span class="s1">radius</span><span class="s2">;</span>
    <span class="s2">}</span>

    <span class="s1">@Override</span>
    <span class="s0">public double </span><span class="s1">getArea</span><span class="s2">() {</span>
        <span class="s0">return </span><span class="s1">Math</span><span class="s2">.</span><span class="s1">PI </span><span class="s2">* </span><span class="s1">radius </span><span class="s2">* </span><span class="s1">radius</span><span class="s2">;</span>
    <span class="s2">}</span>

    <span class="s1">@Override</span>
    <span class="s0">public </span><span class="s1">String getDetails</span><span class="s2">() {</span>
        <span class="s0">return   </span><span class="s1">radius</span><span class="s2">;</span>
    <span class="s2">}</span>
<span class="s2">}</span>

<span class="s0">class </span><span class="s1">Rectangle </span><span class="s0">extends </span><span class="s1">Shape </span><span class="s2">{</span>
    <span class="s0">private double </span><span class="s1">width</span><span class="s2">, </span><span class="s1">height</span><span class="s2">;</span>

    <span class="s0">public </span><span class="s1">Rectangle</span><span class="s2">(</span><span class="s0">double </span><span class="s1">width</span><span class="s2">, </span><span class="s0">double </span><span class="s1">height</span><span class="s2">) {</span>
        <span class="s0">this</span><span class="s2">.</span><span class="s1">width </span><span class="s2">= </span><span class="s1">width</span><span class="s2">;</span>
        <span class="s0">this</span><span class="s2">.</span><span class="s1">height </span><span class="s2">= </span><span class="s1">height</span><span class="s2">;</span>
    <span class="s2">}</span>

    <span class="s1">@Override</span>
    <span class="s0">public double </span><span class="s1">getArea</span><span class="s2">() {</span>
        <span class="s0">return </span><span class="s1">width </span><span class="s2">* </span><span class="s1">height</span><span class="s2">;</span>
    <span class="s2">}</span>

    <span class="s1">@Override</span>
    <span class="s0">public </span><span class="s1">String getDetails</span><span class="s2">() {</span>
        <span class="s0">return  </span><span class="s1">width </span><span class="s2">,  </span><span class="s1">height</span><span class="s2">;</span>
    <span class="s2">}</span>
<span class="s2">}</span>

<span class="s0">public class </span><span class="s1">Server </span><span class="s2">{</span>
    <span class="s0">public static void </span><span class="s1">main</span><span class="s2">(</span><span class="s1">String</span><span class="s2">[] </span><span class="s1">args</span><span class="s2">) {</span>
        <span class="s0">try </span><span class="s2">(</span><span class="s1">ServerSocket serverSocket </span><span class="s2">= </span><span class="s0">new </span><span class="s1">ServerSocket</span><span class="s2">(</span><span class="s4">12345</span><span class="s2">)) {</span>
            <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">(</span><span class="s5">&quot;Server started &quot;</span><span class="s2">);</span>

            <span class="s0">try </span><span class="s2">(</span><span class="s1">Socket clientSocket </span><span class="s2">= </span><span class="s1">serverSocket</span><span class="s2">.</span><span class="s1">accept</span><span class="s2">();</span>
                 <span class="s1">ObjectInputStream input </span><span class="s2">= </span><span class="s0">new </span><span class="s1">ObjectInputStream</span><span class="s2">(</span><span class="s1">clientSocket</span><span class="s2">.</span><span class="s1">getInputStream</span><span class="s2">());</span>
                 <span class="s1">ObjectOutputStream output </span><span class="s2">= </span><span class="s0">new </span><span class="s1">ObjectOutputStream</span><span class="s2">(</span><span class="s1">clientSocket</span><span class="s2">.</span><span class="s1">getOutputStream</span><span class="s2">())) {</span>

                <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">(</span><span class="s5">&quot; connected: &quot; </span><span class="s2">+ </span><span class="s1">clientSocket</span><span class="s2">.</span><span class="s1">getInetAddress</span><span class="s2">());</span>

                <span class="s0">while </span><span class="s2">(</span><span class="s0">true</span><span class="s2">) {</span>
                    <span class="s1">Object obj </span><span class="s2">= </span><span class="s1">input</span><span class="s2">.</span><span class="s1">readObject</span><span class="s2">();</span>
                    <span class="s0">if </span><span class="s2">(</span><span class="s1">obj </span><span class="s2">== </span><span class="s0">null</span><span class="s2">) {</span>
                        <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">(</span><span class="s5">&quot; disconnected&quot;</span><span class="s2">);</span>
                        <span class="s0">break</span><span class="s2">;</span>
                    <span class="s2">}</span>

                    <span class="s1">Shape shape </span><span class="s2">= (</span><span class="s1">Shape</span><span class="s2">) </span><span class="s1">obj</span><span class="s2">;</span>
                    <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">( </span><span class="s1">shape</span><span class="s2">.</span><span class="s1">getDetails</span><span class="s2">());</span>

                    <span class="s0">double </span><span class="s1">area </span><span class="s2">= </span><span class="s1">shape</span><span class="s2">.</span><span class="s1">getArea</span><span class="s2">();</span>
                    <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">( </span><span class="s1">area</span><span class="s2">);</span>

                    <span class="s1">output</span><span class="s2">.</span><span class="s1">writeObject</span><span class="s2">( </span><span class="s1">area</span><span class="s2">);</span>
                <span class="s2">}</span>
            <span class="s2">}</span>
        <span class="s2">} </span><span class="s0">catch </span><span class="s2">(</span><span class="s1">Exception e</span><span class="s2">) {</span>
            <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">(</span><span class="s5">&quot; error: &quot; </span><span class="s2">+ </span><span class="s1">e</span><span class="s2">.</span><span class="s1">getMessage</span><span class="s2">());</span>
        <span class="s2">}</span>
    <span class="s2">}</span>
<span class="s2">}</span>

</pre>
</body>
</html>