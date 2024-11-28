<html>
<head>
<title>ExamChecker.java</title>
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
ExamChecker.java</font>
</center></td></tr></table>
<pre><span class="s0">import </span><span class="s1">java</span><span class="s2">.</span><span class="s1">time</span><span class="s2">.</span><span class="s1">LocalDateTime</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">java</span><span class="s2">.</span><span class="s1">time</span><span class="s2">.</span><span class="s1">format</span><span class="s2">.</span><span class="s1">DateTimeFormatter</span><span class="s2">;</span>
<span class="s3">//ALI</span>
<span class="s0">class </span><span class="s1">ExamChecking </span><span class="s0">extends </span><span class="s1">Thread </span><span class="s2">{</span>
    <span class="s0">private static int </span><span class="s1">examSheets </span><span class="s2">= </span><span class="s4">1000</span><span class="s2">;</span>
    <span class="s0">private static final </span><span class="s1">Object lock </span><span class="s2">= </span><span class="s0">new </span><span class="s1">Object</span><span class="s2">(); </span>
    <span class="s0">private final </span><span class="s1">String assistantName</span><span class="s2">;</span>

    <span class="s0">public </span><span class="s1">ExamChecking</span><span class="s2">(</span><span class="s1">String assistantName</span><span class="s2">) {</span>
        <span class="s0">this</span><span class="s2">.</span><span class="s1">assistantName </span><span class="s2">= </span><span class="s1">assistantName</span><span class="s2">;</span>
    <span class="s2">}</span>

    <span class="s1">@Override</span>
    <span class="s0">public void </span><span class="s1">run</span><span class="s2">() {</span>
        <span class="s0">int </span><span class="s1">checkedSheets </span><span class="s2">= </span><span class="s4">0</span><span class="s2">;</span>
        <span class="s0">while </span><span class="s2">(</span><span class="s1">examSheets </span><span class="s2">&gt; </span><span class="s4">0</span><span class="s2">) {</span>
            <span class="s0">synchronized </span><span class="s2">(</span><span class="s1">lock</span><span class="s2">) {</span>
                <span class="s0">if </span><span class="s2">(</span><span class="s1">examSheets </span><span class="s2">&gt;= </span><span class="s4">25</span><span class="s2">) {</span>
                    <span class="s1">examSheets </span><span class="s2">-= </span><span class="s4">25</span><span class="s2">;</span>
                    <span class="s1">checkedSheets </span><span class="s2">+= </span><span class="s4">25</span><span class="s2">;</span>
                    <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">(</span><span class="s1">assistantName </span><span class="s2">+ </span><span class="s5">&quot; finished checking, at: &quot; </span><span class="s2">+</span>
                            <span class="s1">LocalDateTime</span><span class="s2">.</span><span class="s1">now</span><span class="s2">().</span><span class="s1">format</span><span class="s2">(</span><span class="s1">DateTimeFormatter</span><span class="s2">.</span><span class="s1">ofPattern</span><span class="s2">(</span><span class="s5">&quot;EEE MMM dd HH:mm:ss yyyy&quot;</span><span class="s2">)) +</span>
                            <span class="s5">&quot;, exam sheet count is now &quot; </span><span class="s2">+ </span><span class="s1">examSheets</span><span class="s2">);</span>
                <span class="s2">} </span><span class="s0">else </span><span class="s2">{</span>
                    <span class="s0">break</span><span class="s2">;</span>
                <span class="s2">}</span>
            <span class="s2">}</span>

            <span class="s0">try </span><span class="s2">{</span>
                <span class="s1">Thread</span><span class="s2">.</span><span class="s1">sleep</span><span class="s2">(</span><span class="s4">1500</span><span class="s2">);</span>
            <span class="s2">} </span><span class="s0">catch </span><span class="s2">(</span><span class="s1">InterruptedException e</span><span class="s2">) {</span>
                <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">(</span><span class="s1">assistantName </span><span class="s2">+ </span><span class="s5">&quot; was interrupted.&quot;</span><span class="s2">);</span>
            <span class="s2">}</span>
        <span class="s2">}</span>
        <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">(</span><span class="s1">assistantName </span><span class="s2">+ </span><span class="s5">&quot; has finished checking their assigned sheets.&quot;</span><span class="s2">);</span>
    <span class="s2">}</span>
<span class="s2">}</span>

<span class="s0">public class </span><span class="s1">ExamChecker </span><span class="s2">{</span>
    <span class="s0">public static void </span><span class="s1">main</span><span class="s2">(</span><span class="s1">String</span><span class="s2">[] </span><span class="s1">args</span><span class="s2">) {</span>
        <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">(</span><span class="s5">&quot;Starting the exam sheet checking process...&quot;</span><span class="s2">);</span>

        <span class="s3">// Создаем ассистентов</span>
        <span class="s1">ExamChecking marlen </span><span class="s2">= </span><span class="s0">new </span><span class="s1">ExamChecking</span><span class="s2">(</span><span class="s5">&quot;Marlen&quot;</span><span class="s2">);</span>
        <span class="s1">ExamChecking abunasir </span><span class="s2">= </span><span class="s0">new </span><span class="s1">ExamChecking</span><span class="s2">(</span><span class="s5">&quot;Abunasir&quot;</span><span class="s2">);</span>
        <span class="s1">ExamChecking aldiyar </span><span class="s2">= </span><span class="s0">new </span><span class="s1">ExamChecking</span><span class="s2">(</span><span class="s5">&quot;Aldiyar&quot;</span><span class="s2">);</span>

        <span class="s1">marlen</span><span class="s2">.</span><span class="s1">start</span><span class="s2">();</span>

        <span class="s0">try </span><span class="s2">{</span>
            <span class="s1">Thread</span><span class="s2">.</span><span class="s1">sleep</span><span class="s2">(</span><span class="s4">2000</span><span class="s2">);</span>
            <span class="s1">abunasir</span><span class="s2">.</span><span class="s1">start</span><span class="s2">();</span>

            <span class="s1">Thread</span><span class="s2">.</span><span class="s1">sleep</span><span class="s2">(</span><span class="s4">3000</span><span class="s2">);</span>
            <span class="s1">aldiyar</span><span class="s2">.</span><span class="s1">start</span><span class="s2">();</span>
        <span class="s2">} </span><span class="s0">catch </span><span class="s2">(</span><span class="s1">InterruptedException e</span><span class="s2">) {</span>
            <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">(</span><span class="s5">&quot;Main thread was interrupted.&quot;</span><span class="s2">);</span>
        <span class="s2">}</span>

        <span class="s0">try </span><span class="s2">{</span>
            <span class="s1">marlen</span><span class="s2">.</span><span class="s1">join</span><span class="s2">();</span>
            <span class="s1">abunasir</span><span class="s2">.</span><span class="s1">join</span><span class="s2">();</span>
            <span class="s1">aldiyar</span><span class="s2">.</span><span class="s1">join</span><span class="s2">();</span>
        <span class="s2">} </span><span class="s0">catch </span><span class="s2">(</span><span class="s1">InterruptedException e</span><span class="s2">) {</span>
            <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">(</span><span class="s5">&quot;Main thread was interrupted.&quot;</span><span class="s2">);</span>
        <span class="s2">}</span>

        <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">(</span><span class="s5">&quot;All assistants have completed their work.&quot;</span><span class="s2">);</span>
    <span class="s2">}</span>
<span class="s2">}</span>



</pre>
</body>
</html>