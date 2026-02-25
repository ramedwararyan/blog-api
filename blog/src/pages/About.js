import userContext from "../context/userContext";
import Base from "../components/Base";

const About = () => {
  return (
    <userContext.Consumer>
      {(object) => (
        <Base>
          <div style={styles.container}>
            {/* Heading */}
            <h1 style={styles.title}>About Our Blog Platform</h1>
            <p style={styles.subtitle}>
              A modern blogging platform built to share knowledge, ideas, and creativity.
            </p>

            {/* Section */}
            <section style={styles.section}>
              <h2 style={styles.sectionTitle}>🚀 What We Do</h2>
              <p style={styles.text}>
                We are building a full-stack blog application where users can
                create, read, update, and manage blog posts seamlessly.
                Our goal is to provide a simple yet powerful platform for writers
                and readers.
              </p>
            </section>

            {/* Features */}
            <section style={styles.section}>
              <h2 style={styles.sectionTitle}>✨ Key Features</h2>
              <ul style={styles.list}>
                <li>User authentication & authorization</li>
                <li>Create, edit, and delete blog posts</li>
                <li>Category-based content organization</li>
                <li>Responsive and clean UI</li>
              </ul>
            </section>

            {/* User Info */}
            {object?.user?.login && (
              <section style={styles.userBox}>
                <h3 style={styles.userTitle}>👋 Welcome Back</h3>
                <p style={styles.userText}>
                  Logged in as <strong>{object.user.data.name}</strong>
                </p>
              </section>
            )}
          </div>
        </Base>
      )}
    </userContext.Consumer>
  );
};

export default About;

/* Inline styles */
const styles = {
  container: {
    maxWidth: "900px",
    margin: "0 auto",
    padding: "40px 20px",
  },
  title: {
    fontSize: "36px",
    fontWeight: "700",
    marginBottom: "10px",
    textAlign: "center",
  },
  subtitle: {
    fontSize: "18px",
    color: "#555",
    textAlign: "center",
    marginBottom: "40px",
  },
  section: {
    marginBottom: "30px",
  },
  sectionTitle: {
    fontSize: "24px",
    marginBottom: "10px",
  },
  text: {
    fontSize: "16px",
    lineHeight: "1.7",
    color: "#333",
  },
  list: {
    paddingLeft: "20px",
    lineHeight: "1.8",
  },
  userBox: {
    marginTop: "40px",
    padding: "20px",
    backgroundColor: "#f4f6f8",
    borderRadius: "8px",
    textAlign: "center",
  },
  userTitle: {
    marginBottom: "8px",
  },
  userText: {
    fontSize: "16px",
  },
};