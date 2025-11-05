        // Initialize data storage
        let userProgress = JSON.parse(localStorage.getItem('userProgress')) || {
            completedNotes: [],
            bookmarks: [],
            quizScore: 0,
            totalNotes: 45,
            achievements: []
        };

        // Quiz questions by category
        const quizQuestions = {
            all: [
                {
                    question: "What does HTML stand for?",
                    options: [
                        "Hyper Text Markup Language",
                        "High Tech Modern Language",
                        "Home Tool Markup Language",
                        "Hyperlinks and Text Markup Language"
                    ],
                    correct: 0
                },
                {
                    question: "Which CSS property is used to change the text color?",
                    options: ["text-color", "color", "font-color", "text-style"],
                    correct: 1
                },
                {
                    question: "How do you declare a constant in JavaScript?",
                    options: ["var", "let", "const", "constant"],
                    correct: 2
                },
                {
                    question: "Which is NOT a programming language?",
                    options: ["Python", "HTML", "Java", "C++"],
                    correct: 1
                },
                {
                    question: "What does HTTP stand for?",
                    options: [
                        "HyperText Transfer Protocol",
                        "HighText Transfer Program",
                        "HyperText Transmission Protocol",
                        "Hyper Transfer Text Protocol"
                    ],
                    correct: 0
                },
                {
                    question: "Which company developed JavaScript?",
                    options: ["Netscape", "Microsoft", "Sun Microsystems", "Oracle"],
                    correct: 0
                },
                {
                    question: "What is the default port for HTTP?",
                    options: ["443", "80", "21", "8080"],
                    correct: 1
                },
                {
                    question: "Which tag is used to display an image in HTML?",
                    options: ["<pic>", "<image>", "<img>", "<src>"],
                    correct: 2
                },
                {
                    question: "Which symbol is used for comments in CSS?",
                    options: ["// comment", "# comment", "/* comment */", "<!-- comment -->"],
                    correct: 2
                },
                {
                    question: "Which JavaScript keyword is used to define a variable?",
                    options: ["define", "var", "letvar", "dim"],
                    correct: 1
                }
            ],
            website: [
                {
                    question: "What does CSS stand for?",
                    options: [
                        "Computer Style Sheets",
                        "Creative Style Sheets",
                        "Cascading Style Sheets",
                        "Colorful Style Sheets"
                    ],
                    correct: 2
                },
                {
                    question: "Which HTML5 tag is used for navigation?",
                    options: ["<navigation>", "<nav>", "<menu>", "<navbar>"],
                    correct: 1
                },
                {
                    question: "What is the purpose of Bootstrap?",
                    options: [
                        "Backend framework",
                        "CSS framework for responsive design",
                        "JavaScript library",
                        "Database system"
                    ],
                    correct: 1
                },
                {
                    question: "Which tag is used to create a numbered list?",
                    options: ["<ul>", "<ol>", "<dl>", "<list>"],
                    correct: 1
                },
                {
                    question: "What does the <meta> tag do?",
                    options: [
                        "Defines metadata about an HTML document",
                        "Displays images",
                        "Creates a new section",
                        "Adds a link"
                    ],
                    correct: 0
                },
                {
                    question: "Which protocol is more secure than HTTP?",
                    options: ["FTP", "SSH", "HTTPS", "SMTP"],
                    correct: 2
                },
                {
                    question: "Which of these is a popular JavaScript frontend framework?",
                    options: ["Laravel", "React", "Django", "Spring"],
                    correct: 1
                },
                {
                    question: "Which HTML tag is used to embed a video?",
                    options: ["<video>", "<media>", "<movie>", "<vid>"],
                    correct: 0
                },
                {
                    question: "What is SEO in web development?",
                    options: [
                        "Simple Email Optimization",
                        "Search Engine Optimization",
                        "System Entry Operation",
                        "Search Engine Operation"
                    ],
                    correct: 1
                },
                {
                    question: "What does a favicon represent?",
                    options: [
                        "Page description",
                        "Website icon in the browser tab",
                        "Hidden link",
                        "Copyright info"
                    ],
                    correct: 1
                }
            ],
            html: [
                {
                    question: "Which attribute is used to provide alternate text for an image?",
                    options: ["title", "alt", "src", "href"],
                    correct: 1
                },
                {
                    question: "What is the correct HTML for creating a hyperlink?",
                    options: [
                        "<a href='url'>link</a>",
                        "<link>url</link>",
                        "<hyperlink>url</hyperlink>",
                        "<h>url</h>"
                    ],
                    correct: 0
                },
                {
                    question: "Which HTML tag is used for the largest heading?",
                    options: ["<heading>", "<h6>", "<h1>", "<head>"],
                    correct: 2
                },
                {
                    question: "Which HTML element defines the title of a document?",
                    options: ["<meta>", "<title>", "<head>", "<header>"],
                    correct: 1
                },
                {
                    question: "How can you make a list that shows bullets?",
                    options: ["<ul>", "<ol>", "<list>", "<dl>"],
                    correct: 0
                },
                {
                    question: "Which HTML attribute specifies an inline style?",
                    options: ["style", "css", "font", "class"],
                    correct: 0
                },
                {
                    question: "Which element is used to display preformatted text?",
                    options: ["<code>", "<pre>", "<format>", "<text>"],
                    correct: 1
                },
                {
                    question: "What does the <hr> tag represent?",
                    options: [
                        "A horizontal rule",
                        "A header",
                        "A line break",
                        "A highlighted region"
                    ],
                    correct: 0
                },
                {
                    question: "Which tag is used for table rows?",
                    options: ["<td>", "<tr>", "<th>", "<row>"],
                    correct: 1
                },
                {
                    question: "Which HTML tag is used to define an internal style sheet?",
                    options: ["<css>", "<style>", "<script>", "<link>"],
                    correct: 1
                }
            ],
            css: [
                {
                    question: "Which CSS property controls the text size?",
                    options: ["text-style", "font-size", "text-size", "font-style"],
                    correct: 1
                },
                {
                    question: "How do you make each word in a text start with a capital letter?",
                    options: [
                        "text-transform: capitalize",
                        "text-style: capitalize",
                        "text-decoration: capitalize",
                        "text-case: capitalize"
                    ],
                    correct: 0
                },
                {
                    question: "Which property is used to change the background color?",
                    options: ["color", "background-color", "bgcolor", "background"],
                    correct: 1
                },
                {
                    question: "How do you select an element with id 'header'?",
                    options: [".header", "header", "#header", "*header"],
                    correct: 2
                },
                {
                    question: "Which value of position places an element relative to its first positioned ancestor?",
                    options: ["absolute", "relative", "fixed", "static"],
                    correct: 0
                },
                {
                    question: "Which property is used to change the font of an element?",
                    options: ["font-style", "font-family", "font-type", "font-weight"],
                    correct: 1
                },
                {
                    question: "How do you make text bold using CSS?",
                    options: [
                        "font-weight: bold;",
                        "style: bold;",
                        "text:bold;",
                        "font:bold;"
                    ],
                    correct: 0
                },
                {
                    question: "Which CSS property is used to add space inside an element?",
                    options: ["padding", "margin", "border", "spacing"],
                    correct: 0
                },
                {
                    question: "Which CSS property is used to center text?",
                    options: [
                        "align: center",
                        "text-align: center",
                        "text: center",
                        "center: text"
                    ],
                    correct: 1
                },
                {
                    question: "How do you write a CSS comment?",
                    options: ["// comment", "/* comment */", "<!-- comment -->", "# comment"],
                    correct: 1
                }
            ],
            javascript: [
                {
                    question: "How do you write 'Hello World' in an alert box?",
                    options: [
                        "alert('Hello World');",
                        "msgBox('Hello World');",
                        "alertBox('Hello World');",
                        "msg('Hello World');"
                    ],
                    correct: 0
                },
                {
                    question: "How do you create a function in JavaScript?",
                    options: [
                        "function = myFunction() {}",
                        "function myFunction() {}",
                        "function:myFunction() {}",
                        "createFunction myFunction() {}"
                    ],
                    correct: 1
                },
                {
                    question: "Which symbol is used for comments in JavaScript?",
                    options: ["//", "#", "/*", "<!--"],
                    correct: 0
                },
                {
                    question: "How do you write an IF statement in JavaScript?",
                    options: [
                        "if x > 5 then",
                        "if (x > 5)",
                        "if x > 5 {}",
                        "if x > 5 end"
                    ],
                    correct: 1
                },
                {
                    question: "How do you call a function named myFunction?",
                    options: [
                        "call myFunction()",
                        "myFunction()",
                        "run myFunction()",
                        "execute myFunction()"
                    ],
                    correct: 1
                },
                {
                    question: "Which operator is used to assign a value to a variable?",
                    options: ["=", "==", "===", ":"],
                    correct: 0
                },
                {
                    question: "How do you write a loop that runs 5 times?",
                    options: [
                        "for (i=0; i<5; i++)",
                        "for (i<=5; i++)",
                        "loop (5)",
                        "while (i<5; i++)"
                    ],
                    correct: 0
                },
                {
                    question: "What keyword is used to exit a loop?",
                    options: ["stop", "return", "break", "exit"],
                    correct: 2
                },
                {
                    question: "Which built-in method converts a string to uppercase?",
                    options: [
                        "changeCase()",
                        "upperCase()",
                        "toUpperCase()",
                        "makeUpper()"
                    ],
                    correct: 2
                },
                {
                    question: "Which method adds an element to the end of an array?",
                    options: ["push()", "append()", "add()", "concat()"],
                    correct: 0
                }
            ],
            python: [
                {
                    question: "How do you start a comment in Python?",
                    options: ["//", "#", "/*", "--"],
                    correct: 1
                },
                {
                    question: "Which method is used to add an item to the end of a list?",
                    options: ["add()", "append()", "insert()", "push()"],
                    correct: 1
                },
                {
                    question: "How do you define a function in Python?",
                    options: [
                        "function myFunc():",
                        "def myFunc():",
                        "func myFunc():",
                        "define myFunc():"
                    ],
                    correct: 1
                },
                {
                    question: "Which keyword is used for loops in Python?",
                    options: ["loop", "repeat", "for", "iterate"],
                    correct: 2
                },
                {
                    question: "Which data type is immutable in Python?",
                    options: ["list", "set", "tuple", "dict"],
                    correct: 2
                },
                {
                    question: "How do you import a module in Python?",
                    options: [
                        "#import module",
                        "use module",
                        "import module",
                        "include module"
                    ],
                    correct: 2
                },
                {
                    question: "Which keyword is used to handle exceptions?",
                    options: ["handle", "try", "except", "catch"],
                    correct: 2
                },
                {
                    question: "What does the len() function do?",
                    options: [
                        "Returns the number of characters or elements",
                        "Calculates length in bytes",
                        "Returns file size",
                        "None of the above"
                    ],
                    correct: 0
                },
                {
                    question: "Which operator is used for exponentiation?",
                    options: ["^", "**", "exp()", "pow"],
                    correct: 1
                },
                {
                    question: "How do you print without a newline?",
                    options: [
                        "print(x, newline=False)",
                        "print(x, end='')",
                        "print.noNewline(x)",
                        "print(x, n=False)"
                    ],
                    correct: 1
                }
            ],
            mobile: [
                {
                    question: "What command is used to create a new Flutter project?",
                    options: ["flutter init", "flutter create", "flutter start", "flutter new"],
                    correct: 1
                },
                {
                    question: "Which platform uses Dart programming language?",
                    options: ["React Native", "Flutter", "Swift", "Kotlin"],
                    correct: 1
                },
                {
                    question: "Which language is primarily used for Android development?",
                    options: ["Swift", "Kotlin", "Objective-C", "Dart"],
                    correct: 1
                },
                {
                    question: "Which language is used for iOS development?",
                    options: ["Kotlin", "Swift", "Dart", "React"],
                    correct: 1
                },
                {
                    question: "Which framework allows JavaScript for mobile apps?",
                    options: ["Xamarin", "Flutter", "React Native", "Ionic"],
                    correct: 2
                },
                {
                    question: "What file format are Android apps packaged in?",
                    options: [".zip", ".exe", ".apk", ".jar"],
                    correct: 2
                },
                {
                    question: "Which tool is used to build iOS apps?",
                    options: ["Xcode", "Android Studio", "Visual Studio", "Atom"],
                    correct: 0
                },
                {
                    question: "What is the main advantage of cross-platform development?",
                    options: [
                        "Better graphics",
                        "One codebase for multiple platforms",
                        "Faster hardware performance",
                        "Offline access"
                    ],
                    correct: 1
                },
                {
                    question: "Which mobile OS is open source?",
                    options: ["iOS", "Android", "Windows Mobile", "BlackBerry OS"],
                    correct: 1
                },
                {
                    question: "What is the entry point of a Flutter app?",
                    options: ["main.dart", "index.dart", "start.dart", "init.dart"],
                    correct: 0
                }
            ],
            game: [
                {
                    question: "Which programming language is primarily used in Unity?",
                    options: ["Python", "JavaScript", "C#", "Java"],
                    correct: 2
                },
                {
                    question: "What is the main language used in Godot?",
                    options: ["GDScript", "C#", "Python", "Java"],
                    correct: 0
                },
                {
                    question: "Which engine developed Fortnite?",
                    options: ["CryEngine", "Unity", "Unreal Engine", "Godot"],
                    correct: 2
                },
                {
                    question: "What does FPS stand for in gaming?",
                    options: [
                        "First Person Shooter",
                        "Frames Per Second",
                        "Fast Play System",
                        "Frame Player Setup"
                    ],
                    correct: 1
                },
                {
                    question: "Which company developed Unity?",
                    options: ["Epic Games", "Unity Technologies", "Valve", "EA"],
                    correct: 1
                },
                {
                    question: "Which platform is popular for 2D pixel games?",
                    options: ["Unreal Engine", "Unity", "Godot", "CryEngine"],
                    correct: 2
                },
                {
                    question: "What file format is used for 3D models?",
                    options: [".jpg", ".fbx", ".mp3", ".xml"],
                    correct: 1
                },
                {
                    question: "Which scripting language can be used in Unreal Engine?",
                    options: ["Python", "Blueprints", "Ruby", "Lua"],
                    correct: 1
                },
                {
                    question: "What does GPU stand for?",
                    options: [
                        "Game Processing Unit",
                        "Graphics Processing Unit",
                        "Graphical Programming Unit",
                        "Gaming Power Unit"
                    ],
                    correct: 1
                },
                {
                    question: "Which platform is used for browser-based games?",
                    options: ["C#", "JavaScript", "C++", "Swift"],
                    correct: 1
                }
            ],
            ai: [
                {
                    question: "Which library is used for data manipulation in Python?",
                    options: ["NumPy", "Pandas", "Matplotlib", "TensorFlow"],
                    correct: 1
                },
                {
                    question: "What does NumPy stand for?",
                    options: [
                        "Number Python",
                        "Numerical Python",
                        "New Python",
                        "Numeric Python"
                    ],
                    correct: 1
                },
                {
                    question: "Which library is mainly used for deep learning?",
                    options: ["Scikit-learn", "TensorFlow", "Matplotlib", "Pandas"],
                    correct: 1
                },
                {
                    question: "What does AI stand for?",
                    options: [
                        "Artificial Integration",
                        "Artificial Intelligence",
                        "Automatic Interface",
                        "Advanced Interaction"
                    ],
                    correct: 1
                },
                {
                    question: "Which algorithm is used for classification problems?",
                    options: ["K-Means", "Linear Regression", "Decision Tree", "Apriori"],
                    correct: 2
                },
                {
                    question: "Which function is used to train a model in TensorFlow?",
                    options: [
                        "model.train()",
                        "model.fit()",
                        "model.learn()",
                        "model.train_on_data()"
                    ],
                    correct: 1
                },
                {
                    question: "What is the full form of NLP?",
                    options: [
                        "Natural Learning Process",
                        "Natural Language Processing",
                        "Neural Language Program",
                        "Network Language Processing"
                    ],
                    correct: 1
                },
                {
                    question: "Which library is used for data visualization in Python?",
                    options: ["TensorFlow", "Matplotlib", "Numpy", "Pytorch"],
                    correct: 1
                },
                {
                    question: "What does CNN stand for?",
                    options: [
                        "Central Neural Network",
                        "Convolutional Neural Network",
                        "Complex Neural Node",
                        "Coded Neural Network"
                    ],
                    correct: 1
                },
                {
                    question: "Which popular Python library is used for machine learning?",
                    options: ["TensorFlow", "React", "Laravel", "Django"],
                    correct: 0
                }
            ]
        };

        let currentQuizCategory = 'all';
        let currentQuestionIndex = 0;
        let selectedAnswer = null;

        // Initialize on page load
        document.addEventListener('DOMContentLoaded', () => {
            loadTheme();
            updateProgress();
            loadBookmarks();
            loadRandomQuestion();
            showStickyNote();

            // Set total notes count based on actual notes
            const totalNotes = document.querySelectorAll('.note-card').length;
            userProgress.totalNotes = totalNotes;
            localStorage.setItem('userProgress', JSON.stringify(userProgress));
            updateProgress();
        });

        // Progress Tracker
        function toggleProgress() {
            const tracker = document.getElementById('progressTracker');
            const icon = document.getElementById('progressToggleIcon');
            tracker.classList.toggle('minimized');
            icon.className = tracker.classList.contains('minimized') ?
                'bi bi-chevron-right' : 'bi bi-chevron-left';
        }

        function markAsCompleted(noteId) {
            if (!userProgress.completedNotes.includes(noteId)) {
                userProgress.completedNotes.push(noteId);
                localStorage.setItem('userProgress', JSON.stringify(userProgress));
                updateProgress();
                checkAchievements();
                showNotification('Note marked as completed! 🎉');
            }
        }

        function updateProgress() {
            const completed = userProgress.completedNotes.length;
            const total = userProgress.totalNotes || 45;
            const percentage = Math.round((completed / total) * 100);

            const circle = document.getElementById('progressCircle');
            const circumference = 2 * Math.PI * 65;
            const offset = circumference - (percentage / 100) * circumference;
            circle.style.strokeDashoffset = offset;

            document.getElementById('progressText').textContent = `${percentage}%`;
            document.getElementById('progressDetails').textContent = `${completed} of ${total} completed`;
        }

        // Bookmark functionality
        function toggleBookmark(btn, noteId) {
            const index = userProgress.bookmarks.indexOf(noteId);

            if (index === -1) {
                userProgress.bookmarks.push(noteId);
                btn.classList.add('bookmarked');
                showNotification('Bookmark added!');
            } else {
                userProgress.bookmarks.splice(index, 1);
                btn.classList.remove('bookmarked');
                showNotification('Bookmark removed!');
            }

            localStorage.setItem('userProgress', JSON.stringify(userProgress));
        }

        function loadBookmarks() {
            userProgress.bookmarks.forEach(noteId => {
                const btn = document.querySelector(`[onclick="toggleBookmark(this, '${noteId}')"]`);
                if (btn) btn.classList.add('bookmarked');
            });
        }

        // Search functionality
        document.getElementById('searchInput').addEventListener('input', (e) => {
            const searchTerm = e.target.value.toLowerCase();
            const notes = document.querySelectorAll('.note-card');

            notes.forEach(note => {
                const text = note.textContent.toLowerCase();
                if (text.includes(searchTerm)) {
                    note.parentElement.style.display = 'block';
                } else {
                    note.parentElement.style.display = 'none';
                }
            });
        });

        // Quiz functionality
        function selectQuizCategory(category) {
            currentQuizCategory = category;
            currentQuestionIndex = 0;

            // Update active button
            document.querySelectorAll('.category-btn').forEach(btn => {
                btn.classList.remove('active');
            });
            event.target.classList.add('active');

            loadRandomQuestion();
        }

        function loadRandomQuestion() {
            const questions = quizQuestions[currentQuizCategory] || quizQuestions.all;
            if (questions.length === 0) return;

            currentQuestionIndex = Math.floor(Math.random() * questions.length);
            const question = questions[currentQuestionIndex];

            document.getElementById('quizQuestion').textContent = question.question;

            const optionsContainer = document.getElementById('quizOptions');
            optionsContainer.innerHTML = '';
            question.options.forEach((option, index) => {
                const optionDiv = document.createElement('div');
                optionDiv.className = 'quiz-option';
                optionDiv.textContent = option;
                optionDiv.onclick = () => selectAnswer(index);
                optionsContainer.appendChild(optionDiv);
            });

            document.getElementById('quizFeedback').style.display = 'none';
            document.getElementById('nextBtn').style.display = 'none';
            selectedAnswer = null;
        }

        function selectAnswer(answerIndex) {
            selectedAnswer = answerIndex;
            const options = document.querySelectorAll('.quiz-option');
            options.forEach((opt, index) => {
                opt.classList.toggle('selected', index === answerIndex);
            });

            setTimeout(() => {
                checkAnswer();
            }, 500);
        }

        function checkAnswer() {
            const questions = quizQuestions[currentQuizCategory] || quizQuestions.all;
            const correct = questions[currentQuestionIndex].correct;
            const feedback = document.getElementById('quizFeedback');

            feedback.style.display = 'block';
            if (selectedAnswer === correct) {
                feedback.className = 'quiz-feedback correct';
                feedback.textContent = '✅ Correct! Well done!';
                userProgress.quizScore++;
            } else {
                feedback.className = 'quiz-feedback incorrect';
                feedback.textContent = `❌ Incorrect. The correct answer is: ${questions[currentQuestionIndex].options[correct]}`;
            }

            document.getElementById('quizScore').textContent = userProgress.quizScore;
            localStorage.setItem('userProgress', JSON.stringify(userProgress));

            document.getElementById('nextBtn').style.display = 'inline-block';
        }

        function nextQuestion() {
            loadRandomQuestion();
        }

        // Copy code functionality
        function copyCode(btn) {
            const codeBlock = btn.nextElementSibling.querySelector('code');
            const text = codeBlock.textContent;

            navigator.clipboard.writeText(text).then(() => {
                const originalText = btn.textContent;
                btn.textContent = 'Copied!';
                setTimeout(() => {
                    btn.textContent = originalText;
                }, 2000);
            });
        }

        // FAB menu
        function toggleFab() {
            const menu = document.getElementById('fabMenu');
            const icon = document.getElementById('fabIcon');
            menu.classList.toggle('show');
            icon.className = menu.classList.contains('show') ?
                'bi bi-x-lg' : 'bi bi-plus-lg';
        }

        // Sticky notes
        function showStickyNote() {
            const tips = [
                "Remember to practice coding every day to improve your skills!",
                "Use meaningful variable names for better code readability.",
                "Comment your code to help others understand your logic.",
                "Break down complex problems into smaller, manageable parts.",
                "Don't be afraid to ask for help when you're stuck!",
                "Test your code regularly as you write it.",
                "Learn to debug effectively - it's a crucial developer skill.",
                "Take breaks to avoid burnout and stay productive!",
                "Read other people's code to learn new patterns.",
                "Version control with Git saves time and prevents issues."
            ];

            const note = document.getElementById('stickyNote');
            const text = document.getElementById('stickyNoteText');

            note.classList.add('show');
            text.textContent = tips[Math.floor(Math.random() * tips.length)];

            setTimeout(() => {
                note.classList.remove('show');
            }, 10000);
        }

        // Achievements
        function checkAchievements() {
            const achievements = [];

            if (userProgress.completedNotes.length >= 1 && !userProgress.achievements.includes('first_note')) {
                achievements.push({ id: 'first_note', text: "First Steps - Complete your first note!" });
                userProgress.achievements.push('first_note');
            }
            if (userProgress.completedNotes.length >= 5 && !userProgress.achievements.includes('five_notes')) {
                achievements.push({ id: 'five_notes', text: "Dedicated Learner - Complete 5 notes!" });
                userProgress.achievements.push('five_notes');
            }
            if (userProgress.completedNotes.length >= 10 && !userProgress.achievements.includes('ten_notes')) {
                achievements.push({ id: 'ten_notes', text: "Knowledge Seeker - Complete 10 notes!" });
                userProgress.achievements.push('ten_notes');
            }
            if (userProgress.bookmarks.length >= 5 && !userProgress.achievements.includes('five_bookmarks')) {
                achievements.push({ id: 'five_bookmarks', text: "Bookmark Collector - Save 5 notes!" });
                userProgress.achievements.push('five_bookmarks');
            }
            if (userProgress.quizScore >= 5 && !userProgress.achievements.includes('quiz_master')) {
                achievements.push({ id: 'quiz_master', text: "Quiz Master - Score 5 points!" });
                userProgress.achievements.push('quiz_master');
            }

            if (achievements.length > 0) {
                showAchievement(achievements[0].text);
                localStorage.setItem('userProgress', JSON.stringify(userProgress));
            }
        }

        function showAchievement(text) {
            document.getElementById('achievementText').textContent = text;
            document.getElementById('achievementPopup').classList.add('show');
        }

        function closeAchievement() {
            document.getElementById('achievementPopup').classList.remove('show');
        }

        // Notification system
        function showNotification(message) {
            const notification = document.createElement('div');
            notification.className = 'alert alert-success position-fixed top-0 start-50 translate-middle-x mt-5';
            notification.style.zIndex = '9999';
            notification.textContent = message;
            document.body.appendChild(notification);

            setTimeout(() => {
                notification.remove();
            }, 3000);
        }

        // Export notes
        function downloadNotes() {
            const dataStr = JSON.stringify(userProgress, null, 2);
            const dataUri = 'data:application/json;charset=utf-8,' + encodeURIComponent(dataStr);

            const exportLink = document.createElement('a');
            exportLink.setAttribute('href', dataUri);
            exportLink.setAttribute('download', `coding_progress_${new Date().toISOString().split('T')[0]}.json`);
            document.body.appendChild(exportLink);
            exportLink.click();
            exportLink.remove();

            showNotification('Progress exported successfully!');
        }

        // Show bookmarks
        function showBookmarks() {
            const bookmarkNotes = userProgress.bookmarks;
            if (bookmarkNotes.length === 0) {
                showNotification('No bookmarks yet. Start bookmarking notes!');
                return;
            }

            // Hide all notes first
            document.querySelectorAll('.note-card').forEach(card => {
                card.parentElement.style.display = 'none';
            });

            // Show only bookmarked notes
            bookmarkNotes.forEach(noteId => {
                const card = document.querySelector(`[data-note="${noteId}"]`);
                if (card) card.parentElement.style.display = 'block';
            });

            window.scrollTo({ top: document.getElementById('notes').offsetTop - 100 });
            showNotification(`Showing ${bookmarkNotes.length} bookmarked notes`);

            // Show all notes after 10 seconds
            setTimeout(() => {
                document.querySelectorAll('.note-card').forEach(card => {
                    card.parentElement.style.display = 'block';
                });
            }, 10000);
        }

        // Reset progress
        function resetProgress() {
            if (confirm('Are you sure you want to reset all progress? This cannot be undone.')) {
                userProgress = {
                    completedNotes: [],
                    bookmarks: [],
                    quizScore: 0,
                    totalNotes: document.querySelectorAll('.note-card').length,
                    achievements: []
                };
                localStorage.setItem('userProgress', JSON.stringify(userProgress));
                updateProgress();
                location.reload();
            }
        }

        // Show achievements
        function showAchievements() {
            const completed = userProgress.completedNotes.length;
            const total = userProgress.totalNotes;
            const bookmarked = userProgress.bookmarks.length;
            const score = userProgress.quizScore;
            const achievementCount = userProgress.achievements.length;

            const achievementList = [
                `📚 Notes Completed: ${completed}/${total} (${Math.round((completed / total) * 100)}%)`,
                `🔖 Bookmarks: ${bookmarked}`,
                `🎯 Quiz Score: ${score}`,
                `🏆 Achievements Unlocked: ${achievementCount}`
            ].join('\n');

            alert(`📊 Your Learning Progress:\n\n${achievementList}\n\nKeep up the great work!`);
        }

        // Close menus when clicking outside
        document.addEventListener('click', (e) => {
            const fab = document.querySelector('.fab');
            const fabMenu = document.getElementById('fabMenu');

            if (!fab.contains(e.target) && !fabMenu.contains(e.target)) {
                fabMenu.classList.remove('show');
                document.getElementById('fabIcon').className = 'bi bi-plus-lg';
            }
        });

        // Show sticky note periodically
        setInterval(showStickyNote, 60000);

        // Smooth scrolling for anchor links
        document.querySelectorAll('a[href^="#"]').forEach(anchor => {
            anchor.addEventListener('click', function (e) {
                e.preventDefault();
                const target = document.querySelector(this.getAttribute('href'));
                if (target) {
                    target.scrollIntoView({
                        behavior: 'smooth',
                        block: 'start'
                    });
                }
            });
        });

        // Theme loading (placeholder function)
        function loadTheme() {
            // Implementation for theme loading can be added here
        }
    