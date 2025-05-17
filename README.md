# RedundancyChecker
 Java-based tool to detect redundancy in alt text and captions, aligned with WCAG 2.1, WAI, Paciello Group, and RNIB standards.

Source of conditions: 

1. Similarity Threshold (70% or Higher) 

Supporting Concepts: 

NLP and Content Overlap: In natural language processing, algorithms often flag content with over 70% similarity as potentially redundant. This is because, at that point, two pieces of text are typically conveying the same message or information, which is a major issue in accessibility. 

Usability and Cognitive Load: When content is too similar (whether it's alt text, captions, or other descriptive text), it can result in a high cognitive load for users, especially those with disabilities. Repetition of the same information can be overwhelming for screen reader users, which is a concern addressed in WCAG guidelines. 

Source: WCAG 2.1 - Non-text Content (1.1.1): Describes providing non-redundant text alternatives to images. While it doesn’t specify percentages, it establishes the principle that alt text and other text should not be overly repetitive. 

WCAG 2.1 - Non-text Content 

Usability Testing on Redundancy: 

Research in usability studies (e.g., from Nielsen Norman Group) indicates that users, including those with visual impairments, find redundancy and repeated information frustrating. The common 70% threshold is a heuristic often cited in content evaluation tools to flag redundant descriptions. 

Source: Nielsen Norman Group on Redundancy and Cognitive Load in Accessibility. Nielsen Norman Group 

2. Word Count Threshold (More Than 5 Words) 

Supporting Concepts: 

Conciseness in Alt Text: Accessibility guidelines and best practices stress that alt text should be as brief as possible while still conveying the necessary information. If the alt text shares too many words with a caption (e.g., more than 5 words), it suggests redundancy, as the information is already conveyed through the caption. 

Redundancy Detection: In content analysis, a high degree of overlap in key terms (over 5 words) typically indicates that the two pieces of text are too similar. 

Source: The Web Accessibility Initiative (WAI) has guidelines on using alt text to avoid repetition. Their best practices emphasize brevity and distinctness in alt text, encouraging minimal overlap with adjacent text like captions. 

WAI - Alt Text Best Practices 

Content Redundancy: When captions and alt text overlap heavily, it defeats the purpose of having distinct descriptions for users with different needs (e.g., visual vs. auditory). This practice of avoiding unnecessary repetition is common in accessibility training materials. 

Source: Accessible Digital Content Standards from The Paciello Group, which suggests clear and concise alt text without excessive overlap. 

Paciello Group - Accessible Content 

3. General Practice in Accessibility and Content Design 

Supporting Concepts: 

Avoiding Repetition: Accessibility experts agree that unnecessary repetition of information in alt text and captions can confuse users, particularly those relying on screen readers. Alt text should complement other descriptive content without simply duplicating it. 

Complementary Roles: Alt text and captions should serve complementary, distinct roles. The role of alt text is to convey the function or content of an image succinctly for those who cannot see it, while captions provide more context and description for multimedia content. Both should avoid redundancy. 

Source: The American Foundation for the Blind (AFB): Their guidelines for accessible multimedia emphasize that alt text and captions should be distinct and serve complementary roles, not repeat each other unnecessarily. 

AFB Guide on Alt Text 

Reducing Redundancy: The principle of reducing repetition in alt text and captions comes from broader principles of cognitive accessibility and design. Repeated information can lead to frustration and increase cognitive load, which is particularly challenging for users with disabilities who may process information more slowly or in different ways. 

Source: The Royal National Institute of Blind People (RNIB): Their alt text guidelines stress the importance of avoiding unnecessary repetition of information in both captions and alt text, to ensure content is clear and accessible. 

RNIB - Writing Effective Alt Text 

 
 

While there may not be a single source or official document that directly ties the 70% similarity threshold or 5-word overlap rule to accessibility standards, these practices are informed by a combination of usability research, natural language processing heuristics, and best practices in accessibility. They are grounded in the need to provide distinct, non-repetitive descriptions for users, particularly those relying on screen readers. 

The sources I’ve listed above discuss concepts like reducing redundancy, improving cognitive accessibility, and creating complementary content (alt text and captions) that serves different purposes without overwhelming the user. 

 
